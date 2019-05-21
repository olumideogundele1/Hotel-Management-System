package com.academy.hms.hms.booking;

import com.academy.hms.hms.room.Room;
import com.academy.hms.hms.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    BookingService bookingService;

    @Autowired
    RoomService roomService;

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("/booking")
    public String booking(Model model, String roomId, String dates, int adult, int children,String rTitle, String rPrice){

        LOGGER.info("Room Object " +
                roomId + " " +
                dates + " " +
               adult + " " +
                children + " " +
                rTitle + " " +
                rPrice);
        model.addAttribute("roomId",roomId);
        model.addAttribute("dates",dates);
        model.addAttribute("adult",adult);
        model.addAttribute("children",children);
        model.addAttribute("rTitle",rTitle);
        model.addAttribute("rPrice",rPrice);
        model.addAttribute("booking",new Booking());

        return "booking";
    }
    @GetMapping("/booking")
    public String booking(Model model){
        String roomId=null;
        String dates=null;
        int adult=0;
        int children=0;
        String rTitle=null;
        String rPrice=null;
        model.addAttribute("roomId",roomId);
        model.addAttribute("dates",dates);
        model.addAttribute("adult",adult);
        model.addAttribute("children",children);
        model.addAttribute("rTitle",rTitle);
        model.addAttribute("rPrice",rPrice);
       // model.addAttribute("booking",new Booking());

        return "booking";
    }

    @PostMapping("/save-booking")
    public String saveBooking(@ModelAttribute("booking") @Valid Booking booking, BindingResult bindingResult,Model model){
        LOGGER.info("Bpooking object " + booking.toString());
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(err -> LOGGER.info("ERROR {}", err.getDefaultMessage()));
            model.addAttribute("booking", booking);
            return "booking";
        }
//        bookingService.createBooking(booking);
        return "invoice";
    }

    @GetMapping("/bookings-table")
    public String bookingsTable(Model model) {

        model.addAttribute("booking", bookingService.findBooking());
        return "bookings-table";
    }

    @GetMapping("/cancel-booking")
    public String cancelBooking(@RequestParam Long id) {

        bookingService.cancelBooking(id);
        return "redirect:/bookings-table";
    }

    @PostMapping("/edit-booking")
    public String editBooking(Long id, @ModelAttribute("dates")String dates, @ModelAttribute("adlt")int adults,
                              @ModelAttribute("child")int children, @ModelAttribute("Type")String roomType, @ModelAttribute("Price")String roomPrice,
                              @ModelAttribute("fName")String firstName, @ModelAttribute("lName")String lastName, @ModelAttribute("mail")String email)

    {
        bookingService.editBooking(id, dates, adults, children, roomType, roomPrice, firstName, lastName, email);
        return "redirect:/bookings-table";
    }

    @GetMapping("/{id}/find-one-booking")
    @ResponseBody
    public Booking findOneBooking(@PathVariable Long id, Model model){

        Booking booking = bookingService.findOne(id);
        return booking;
    }
}
