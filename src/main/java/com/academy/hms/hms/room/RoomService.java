package com.academy.hms.hms.room;

import java.util.List;

public interface RoomService {
    void createRoom(Room room);
    void deleteRoom(Long id);
    void editRoom(Long id, String price, String roomDesc, String roomNum, String roomTitle);
    Room findOne(Long id);
    List<Room> findRoom();
}
