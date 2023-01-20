package publics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;
import publics.model.Categorie;
import publics.repository.CategorieRepository;
import publics.repository.TokenRepository;
import publics.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import publics.service.TokenService;

import javax.servlet.http.HttpSession;

@RequestMapping("/categories")
@Controller
public class CategorieController {

    @Autowired
    private CategorieService catServ;
    @Autowired
    private CategorieRepository catRepo;
    @Autowired
    private TokenService serv;
    @Autowired
    private TokenRepository tk;


    @GetMapping
    public Object FetchAll(Model model, HttpSession session) {
        String token=(String)session.getAttribute("token");
        try{
            boolean tr=serv.verification(token,tk.findAll());
            if(tr==false){
                return new RedirectView("logins");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("categorie",catServ.GetAll());
        return "listCategorie";
    }




    @PostMapping
    public Object CreateCategorie(Categorie categorie,Model model,HttpSession session) throws Exception {
            catRepo.save(categorie);
            return FetchAll(model,session);
    }
}

