package com.academy.hms.hms.booking;

import com.academy.hms.hms.extraEntity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Booking extends AbstractEntity {
    @NotEmpty
    private String dates;

    @Min(1)
    @Max(6)
    private int adults;

    @Min(0)
    @Max(4)
    private int children;

    private String roomType;

    private String roomPrice;

    @NotEmpty(message = "Enter first name")
    private String firstName;

    @NotEmpty(message = "Enter last name")
    private String lastName;

    @Email(message = "Enter a valid email address")
    @NotEmpty(message = "Enter email address")
    private String email;

    public Booking(String dates, int adults, int children, String roomType, String roomPrice, String firstName, String lastName, String email) {
        this.dates = dates;
        this.adults = adults;
        this.children = children;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Booking(){}

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "dates='" + dates + '\'' +
                ", adults='" + adults + '\'' +
                ", children='" + children + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
