package com.gituhub.sammejanderson.meetingroom.repository;


import com.gituhub.sammejanderson.meetingroom.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


}
