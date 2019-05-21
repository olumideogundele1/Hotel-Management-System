package com.academy.hms.hms.receptionist;

import com.academy.hms.hms.extraEntity.AbstractEntity;
import com.academy.hms.hms.extraEntity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Receptionist extends AbstractEntity {

    private String fullName;
    private String gender;
    private String email;


    @OneToOne
    private User user;

    public Receptionist(String fullName, String gender, String email) {
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
    }

    public Receptionist(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
