package com.academy.hms.hms.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void createBooking(Booking booking) {

        bookingRepository.save(booking);

    }

    @Override
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void editBooking(Long id, String dates, int adults, int children, String roomType, String roomPrice, String firstName, String lastName, String email) {
        Booking booking = findOne(id);

        booking.setDates(dates);
        booking.setAdults(adults);
        booking.setChildren(children);
        booking.setRoomType(roomType);
        booking.setRoomPrice(roomPrice);
        booking.setFirstName(firstName);
        booking.setLastName(lastName);
        booking.setEmail(email);

        bookingRepository.save(booking);
    }

    @Override
    public Booking findOne(Long id) {
        return bookingRepository.getOne(id);
    }

    @Override
    public List<Booking> findBooking() {
        return bookingRepository.findAll();
    }
}
