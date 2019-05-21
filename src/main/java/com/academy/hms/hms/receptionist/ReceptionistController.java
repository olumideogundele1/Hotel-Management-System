package com.academy.hms.hms.receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;

    @Autowired
    ReceptionistRepository receptionistRepository;

    @GetMapping("/receptionist")
    public String receptionist(){

        return "receptionist";
    }

    @GetMapping("/recep-signup")
    public String recepSU(Model model){
        model.addAttribute("receptionist", new Receptionist());
        return "recep-signup";
    }

    @PostMapping("/receptionist/create")
    public String recepSU(Model model, @ModelAttribute("receptionist") Receptionist receptionist){
        Boolean created = false;
        receptionistService.createReceptionist(receptionist);
        created = true;
        model.addAttribute("created",created);
        return "recep-signup";
    }

    @GetMapping("/recep-table")
    public String recepTable(Model model){

        model.addAttribute("receptionist",receptionistService.findReceptionist());
        return "recep-table";
    }

    @GetMapping("/delete-recep")
    public String deleteRecep(@RequestParam Long id) {

        receptionistService.deleteReceptionist(id);
        return "redirect:/recep-table";
    }

    @PostMapping("/edit-recep")
    public String editRecep(Long id, @ModelAttribute("fName") String fullName, @ModelAttribute("email") String email){
        receptionistService.editReceptionist(id, fullName, email);
        return "redirect:/recep-table";
    }

    @GetMapping("/{id}/find-one")
    @ResponseBody
    public Receptionist findOne(@PathVariable Long id,Model model){

        Receptionist receptionist = receptionistService.findOne(id);
        return receptionist;
    }

}
