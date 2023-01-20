package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.CreditRefus;
import publics.model.Recharge;
import publics.model.Solde;
import publics.model.Utilisateur;
import publics.repository.CreditRefusRepository;
import publics.repository.TokenRepository;
import publics.service.TokenService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/creditRefus")
public class CreditRefusController {
    @Autowired
    private CreditRefusRepository creditRefusRepository;
    @Autowired
    private TokenRepository tk;
    @Autowired
    private TokenService serv;
    @GetMapping
    public Object getAllCredRefus(){
        try{
            //return new Data(creditRefusRepository.findAll());
            return null;
        }catch (Exception e){
            return new Error(e);
        }
    }
    @PostMapping
    public RedirectView save(@RequestParam("iddm") String iddm , @RequestParam("somme") String somme, Model model, HttpSession session){
        String token=(String)session.getAttribute("token");
        try{
            boolean tr=serv.verification(token,tk.findAll());
            if(tr==false){
                return new RedirectView("login");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Recharge rh=new Recharge();
        rh.setIddm(Long.parseLong(iddm));
        CreditRefus refus=new CreditRefus(null,rh);
        creditRefusRepository.save(refus);
        return new RedirectView("recharges");
    }
}
