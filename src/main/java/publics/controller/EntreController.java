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
public class EntreController {
    @RequestMapping("/")
    @GetMapping
    public RedirectView handleRequest(HttpSession session) {
        return new RedirectView("logins");
    }



}
