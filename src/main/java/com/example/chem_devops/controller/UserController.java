package com.example.chem_devops.controller;

import com.example.chem_devops.model.User;
import com.example.chem_devops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //GET method for registration
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    //POST method for registration
    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            model.addAttribute("error_message", "Username exists!");
            return "register";
        }

        userRepository.save(user);
        return "redirect:/login";
    }
}