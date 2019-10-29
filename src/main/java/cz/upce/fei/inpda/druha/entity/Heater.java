package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Heater")
@Table(name = "heater")
public class Heater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Home home;

    @NonNull
    private double power = 0;

    public void setPower(List<Room> rooms) {
        power = 0;

        for (Room room : rooms) {
            if (room.getRequiredTemperature() > room.getActualTemperature()) {
                power += (room.getRequiredTemperature() - room.getActualTemperature()) / 10;
                room.raiseTemperature();
            }
        }
    }

}
