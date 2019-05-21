package com.academy.hms.hms.extraController;

import com.academy.hms.hms.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    RoomService roomService;

    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping("/index")
    public String index0(){ return "index"; }

    @GetMapping("/rooms")
    public String rooms(Model model){
        model.addAttribute("rooms",roomService.findRoom());
        return "rooms";
    }

    @GetMapping("/about-us")
    public String aboutUs(){ return "aboutUs"; }

    @GetMapping("/services")
    public String services(){ return "services"; }

    @GetMapping("/contact")
    public String contact(){ return "contact"; }

    @GetMapping("/elements")
    public String element(){ return "elements"; }

}
