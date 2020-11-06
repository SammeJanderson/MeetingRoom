package com.gituhub.sammejanderson.meetingroom.controller;


import com.gituhub.sammejanderson.meetingroom.exception.ResourceNotFoundException;
import com.gituhub.sammejanderson.meetingroom.model.Room;
import com.gituhub.sammejanderson.meetingroom.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping("/rooms")
    public List<Room> getallRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/room/id")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId)
            throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("room not found: " + roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room){
        return roomRepository.save(room);
    }


    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId,
                                           @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException{
        Room room  = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found for this id::"+ roomId));

        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());

        final Room updateRoom = roomRepository.save(room);
        return  ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteBId(@PathVariable(value = "id") Long roomId) throws  ResourceNotFoundException{
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found for this id::"+ roomId));
        roomRepository.delete(room);

        return "room deleted";

    }

}

