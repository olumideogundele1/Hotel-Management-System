package com.academy.hms.hms.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void createRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public void editRoom(Long id, String price, String roomDesc, String roomNum, String roomTitle) {
        Room room = findOne(id);

        room.setPrice(price);
        room.setRoomDesc(roomDesc);
        room.setRoomNum(roomNum);
        room.setRoomTitle(roomTitle);

        roomRepository.save(room);
    }

    @Override
    public Room findOne(Long id) {
        return roomRepository.getOne(id);
    }

    @Override
    public List<Room> findRoom() {
        return roomRepository.findAll();
    }
}
