package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.Recharge;
import publics.repository.RechargeRepository;
import publics.repository.TokenRepository;
import publics.service.TokenService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/recharges")
public class RechargeController {
    @Autowired
    private RechargeRepository rechargeRepository;
    @Autowired
    private TokenService serv;
    @Autowired
    private TokenRepository tk;
    @GetMapping
    public Object getAllDmd(Model model, HttpSession session){
        String token=(String)session.getAttribute("token");
        try{
            boolean tr=serv.verification(token,tk.findAll());
            if(tr==false){
                return new RedirectView("logins");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("recharge",rechargeRepository.notCheck());
        return "listRecharge";
    }

}
