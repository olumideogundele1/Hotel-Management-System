package com.academy.hms.hms.extraEntity;

import javax.persistence.*;

@Entity
public class Roles extends AbstractEntity {

    private String name;

    private UserType userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "name='" + name + '\'' +
                ", userType=" + userType +
                '}';
    }
}
