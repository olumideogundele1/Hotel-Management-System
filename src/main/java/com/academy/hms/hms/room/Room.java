package com.academy.hms.hms.room;

import com.academy.hms.hms.extraEntity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Room extends AbstractEntity {

    private String roomNum;
    private String roomTitle;
    private String roomDesc;
    private String price;
    private String imagePath;
    private String space;

    public Room(String roomNum, String roomTitle, String roomDesc, String price, String imagePath, String space) {
        this.roomNum = roomNum;
        this.roomTitle = roomTitle;
        this.roomDesc = roomDesc;
        this.price = price;
        this.imagePath = imagePath;
        this.space = space;
    }

    public Room(){}

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNum='" + roomNum + '\'' +
                ", roomTitle='" + roomTitle + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                ", price='" + price + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", space='" + space + '\'' +
                '}';
    }
}
