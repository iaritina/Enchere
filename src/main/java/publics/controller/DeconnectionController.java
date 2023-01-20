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
@RequestMapping("/deconnections")
public class DeconnectionController {
    @Autowired
    private TokenRepository tokenRepo;
    @GetMapping
    public RedirectView handleRequest(HttpSession session) {
        String token=(String)session.getAttribute("token");
        tokenRepo.deconnex(token);
        return new RedirectView("logins");
    }


}
