package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Cooler")
@Table(name = "cooler")
@NoArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class Cooler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @NonNull
    private Home home;

    @NonNull
    private double power = 0;

    public void cool() {
        power = 0;

        for (Room room : home.getRooms()) {
            if (room.getRequiredTemperature() < room.getActualTemperature() - 1) {
                power++;
                room.reduceTemperature();
            }
        }

        log.info("Cooler " + this.getHome().getId() + " " +  this.power);
    }

}
