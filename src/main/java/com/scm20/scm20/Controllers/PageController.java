package com.scm20.scm20.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm20.scm20.entity.User;
import com.scm20.scm20.forms.UserForm;
import com.scm20.scm20.services.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController {

    // @Autowired
    // private UserService userService;
    @Autowired
    private UserService userService;
    

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
    
    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Processing Register");
        
        System.out.println(userForm);

        User savedUser = User.builder().userName(userForm.getName()).email(userForm.getEmail()).password(userForm.getPassword()).build();

        userService.saveUser(savedUser);
        System.out.println("User Saved");


        return "redirect:/login";
    
    }
    
}