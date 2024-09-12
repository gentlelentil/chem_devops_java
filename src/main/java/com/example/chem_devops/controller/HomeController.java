package com.example.chem_devops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal User currentUser) {
        if (currentUser != null) {
            return "redirect:/smiles_generator"; // Redirect to smiles generator if user is logged in
        } else {
            return "redirect:/login"; // Redirect to login if user is not logged in
        }
    }


}
