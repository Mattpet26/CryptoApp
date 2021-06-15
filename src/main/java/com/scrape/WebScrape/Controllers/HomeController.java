package com.scrape.WebScrape.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String RenderHomePage(Principal principal, Model m){
        m.addAttribute("user", principal);
        return "home";
    }
}
