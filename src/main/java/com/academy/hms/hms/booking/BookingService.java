package com.academy.hms.hms.booking;

import java.util.List;

public interface BookingService {
    void createBooking(Booking booking);
    void cancelBooking(Long id);
    void editBooking(Long id, String dates, int adults, int children, String roomType, String roomPrice, String firstName, String lastName, String email);
    Booking findOne(Long id);
    List<Booking> findBooking();
}
