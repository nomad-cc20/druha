package cz.upce.fei.inpda.druha.dto;

import cz.upce.fei.inpda.druha.entity.Room;
import lombok.Data;

@Data
public class RoomDto {

    private long id;
    private long homeId;
    private String name;
    private double actualTemperature;
    private double requiredTemperature;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.homeId = room.getId();
        this.name = room.getName();
        this.actualTemperature = room.getActualTemperature();
        this.requiredTemperature = room.getRequiredTemperature();
    }
}
