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
public class LoginController {
    @Autowired
    private AdminRepository adminrepo;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenAgeService ageService;@RequestMapping("/logins")
    @GetMapping
    public Object handleRequest(HttpSession session) {
        String token=(String)session.getAttribute("token");
        try {
            return verificationToken(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Object verificationToken(String token) throws Exception {
            boolean tr=tokenService.verification(token,tokenRepository.findAll());
            System.out.println(tr);
            if(tr==false)
                return "login";
            else
                return new RedirectView("encheres");
    }


}
