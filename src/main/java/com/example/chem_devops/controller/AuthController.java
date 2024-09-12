package com.example.chem_devops.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.chem_devops.model.LoginForm;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm()); // Add this line
        model.addAttribute("title", "Login");
        return "login"; // This should use the base template
    }


//    @PostMapping("/testlogin")
//    public String loginUser(@RequestParam String username, @RequestParam String password) {
//        // Handle login logic
//        return "redirect:/smiles_generator";
//    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return "redirect:/smiles_generator";
        }
        return "redirect:/login";
    }
}