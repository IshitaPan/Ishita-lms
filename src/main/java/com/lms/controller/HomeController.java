package com.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.entity.User;

@Controller
public class HomeController {
    // @Autowired
    // private PasswordEncoder passwordEncoder;
   
    @RequestMapping ("/")
    public String home(Model model) {
        model.addAttribute("title", "Home- Smart Contact");
        return "home";
    }
    
    @RequestMapping ("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Register- Smart Contact");
        model.addAttribute("user", new User());
        return "register";
    }
    
}
    
