package com.academy.hms.hms.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomsTableController {

    @Autowired
    RoomService roomService;

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/rooms-table")
    public String roomsTable(Model  model){

        model.addAttribute("rooms", roomService.findRoom());
        return "rooms-table";
    }

    @GetMapping("/delete-room")
    public String deleteRoom(@RequestParam Long id){

        roomService.deleteRoom(id);
        return "redirect:/rooms-table";
    }

    @PostMapping("edit-room")
    public String editRoom(Long id, @ModelAttribute("price")String price, @ModelAttribute("desc")String desc, @ModelAttribute("num")String num, @ModelAttribute("type")String type) {

        roomService.editRoom(id, price, desc, num, type);
        return "redirect:/rooms-table";
    }

    @GetMapping("/{id}/find-one-room")
    @ResponseBody
    public Room findOneRoom(@PathVariable Long id,Model model){

        Room room = roomService.findOne(id);
        return room;
    }

}
