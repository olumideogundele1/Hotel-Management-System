package com.academy.hms.hms.extraController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralLogInController {

    @GetMapping("/general-login")
    public String generalLogIn() {

        return "general-login";
    }
}
