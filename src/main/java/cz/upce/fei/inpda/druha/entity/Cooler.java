package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Cooler")
@Table(name = "cooler")
public class Cooler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @NonNull
    private Home home;

    @NonNull
    private double power = 0;

    public void cool(List<Room> rooms) {
        power = 0;

        for (Room room : rooms) {
            room.balanceTemperature();

            if (room.getRequiredTemperature() < room.getActualTemperature() - 1) {
                power--;
                room.reduceTemperature();
            }
        }
    }

}
