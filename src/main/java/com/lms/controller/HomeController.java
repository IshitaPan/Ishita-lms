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
        model.addAttribute("title", "Home- LMS");
        return "home";
    }
    
    @RequestMapping ("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Register- LMS");
        model.addAttribute("user", new User());
        return "register";
    }
    
}
    
