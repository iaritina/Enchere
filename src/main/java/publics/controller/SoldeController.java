package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.Recharge;
import publics.model.Solde;
import publics.model.Utilisateur;
import publics.repository.SoldeRepository;
import publics.repository.TokenRepository;
import publics.service.TokenService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/soldes")
public class SoldeController {
    @Autowired
    private SoldeRepository soldeRepository;
    @Autowired
    private TokenRepository tk;
    @Autowired
    private TokenService serv;
    @GetMapping
    public Object getAllSolde() {
        try {
            //return new Data(soldeRepository.findAll());
            return null;
        } catch (Exception e) {
            return new Error(e);
        }
    }
    @PostMapping
    public RedirectView saveSolde(HttpSession session,@RequestParam("iddm") String iddm, @RequestParam("iduser") String iduser, @RequestParam("somme") String somme, Model model){
        String token=(String)session.getAttribute("token");
        try{
            boolean tr=serv.verification(token,tk.findAll());
            if(tr==false){
                return new RedirectView("logins");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Utilisateur user=new Utilisateur();
        Recharge rh=new Recharge();
        rh.setIddm(Long.parseLong(iddm));
        user.setIduser(Long.parseLong(iduser));
        Solde solde=new Solde(null,user,null,Integer.parseInt(somme),rh);
        LocalDateTime dt=LocalDateTime.now();
        solde.setPeriode(Timestamp.valueOf(dt));
            soldeRepository.save(solde);
            return new RedirectView("recharges");
    }
}
