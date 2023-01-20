package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.NbrCategorie;
import publics.repository.NbrCategorieRepository;
import publics.repository.TokenRepository;
import publics.service.EnchereService;
import publics.service.NbrCategorieService;
import publics.service.TokenService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("statistiques")
public class StatController {
    @Autowired
    private EnchereService serv;
    @Autowired
    private NbrCategorieService cat;
    @Autowired
    private TokenRepository tk;
    @Autowired
    private TokenService servT;

    @GetMapping()
    public Object stat(Model model, HttpSession session) throws Exception{
        String token=(String)session.getAttribute("token");
        try{
            boolean tr=servT.verification(token,tk.findAll());
            if(tr==false){
                return new RedirectView("logins");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("bestSale",serv.bestSale());
        model.addAttribute("nombreVente",serv.enchereNbr());
        model.addAttribute("categorie",cat.list());
        return "statistique";
    }
}
