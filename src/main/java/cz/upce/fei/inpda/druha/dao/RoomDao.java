package cz.upce.fei.inpda.druha.dao;

import cz.upce.fei.inpda.druha.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room, Long> {

}
