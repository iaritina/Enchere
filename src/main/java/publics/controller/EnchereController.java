package publics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.*;
import publics.service.*;
import publics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/encheres")

public class EnchereController {
    @Autowired
    private EnchereService enchereService;
    @Autowired
    private TokenService serv;
    @Autowired
    private TokenRepository tk;
    @GetMapping()
    public Object list(Model model, HttpSession session) throws Exception{
        String token=(String)session.getAttribute("token");
        try{
            boolean tr=serv.verification(token,tk.findAll());
            if(tr==false){
                return new RedirectView("logins");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("enchere",enchereService.findAll());
        return "listEnchere";
    }
}
