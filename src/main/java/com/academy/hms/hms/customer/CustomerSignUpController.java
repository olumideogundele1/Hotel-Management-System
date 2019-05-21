package com.academy.hms.hms.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerSignUpController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("customer", new Customer());
        return "signup";
    }

    @PostMapping("addPersonnel")
    public String signup(@ModelAttribute("personnel") Customer customer){
        customerService.createPersonnel(customer);
        return "login";
    }


}
