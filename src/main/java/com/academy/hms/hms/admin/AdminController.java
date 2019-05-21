package com.academy.hms.hms.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @GetMapping("/admin")
    public String admin(){

            return "admin";
    }

    @GetMapping("/admin-signup")
    public String adminSU(Model model){
        model.addAttribute("admin", new Admin());
        return "admin-signup";
    }

    @PostMapping("addAdmin")
    public String adminSU(@ModelAttribute("admin") Admin admin){
        adminService.createAdmin(admin);
        return "admin-login";
    }

    @PostMapping("/admin-signup")
    public String adminSignUp(){

        return "admin-signup";
    }

    @PostMapping("/recep-signup")
    public String recepSignup(){

        return "create-receptionist";
    }

}
