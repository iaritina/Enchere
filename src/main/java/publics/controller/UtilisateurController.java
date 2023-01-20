package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publics.repository.UtilisateurRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @GetMapping
    public Object getAllUser(){
        try{
            //return new Data(utilisateurRepository.findAll());
            return null;
        }catch (Exception e){
            return new Error(e);
        }
    }
}
