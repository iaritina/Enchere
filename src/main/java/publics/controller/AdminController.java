package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.Admin;
import publics.model.Token;
import publics.repository.AdminRepository;
import publics.repository.TokenRepository;
import publics.service.AdminService;
import publics.service.TokenAgeService;
import publics.service.TokenService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminrepo;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TokenAgeService ageService;


    @PostMapping
    public Object login(Admin admin, Model model, HttpSession session){
        Admin retour =adminService.log(admin);
        try{
        if(retour!=null){
            tokenRepository.expire(retour.getIdadmin());
            String tok=Token.generateToken(retour.getEmail());
            tokenService.save(new Token(tok,retour.getIdadmin(),ageService.expiration()));
            session.setAttribute("token",tok);
           return new RedirectView("encheres");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("error", "email ou mot de passe incorrect");
        return "login";
    }
}
