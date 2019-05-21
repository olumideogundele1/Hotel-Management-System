package com.academy.hms.hms.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomsController {

    @Autowired
    RoomService roomService;

    @PostMapping("/rooms")
    public String rooms(Model model, String dates, int adult, int children){

        model.addAttribute("dates",dates);
        model.addAttribute("adult",adult);
        model.addAttribute("children",children);
        model.addAttribute("rooms",roomService.findRoom());

        return "rooms";
    }

    @GetMapping("/create-room")
    public String createRoom(Model model){
        model.addAttribute("room", new Room());
        return "create-room";
    }

    @PostMapping("/addRoom")
    public String createRoom(@ModelAttribute("room")Room room){
        roomService.createRoom(room);
        return "room-created";
    }

}
