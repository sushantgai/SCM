package com.scm20.scm20.Controllers;
import forms.UserForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class PageController {

    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("subtext", "Paragraph");
        model.addAttribute("link", "https://www.google.com/");
        return "home";
    }

    // About
    @GetMapping("/about")
    public String aboutPage() {
        System.out.println("About Page Handler");
        return "about";
    }

    // Services
    @GetMapping("/services")
    public String servicesPage() {
        System.out.println("Services Page Handler");
        return "services";
    }

    // Contact
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    // Login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Register
    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // Process Register
    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Processing Register");
        // fetch form data
        System.out.println(userForm);
        
        //validate data 

        // save to database

        
        // redirect to login page
        return "redirect:/login";
    }
}