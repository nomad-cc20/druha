package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Heater")
@Table(name = "heater")
@NoArgsConstructor
@RequiredArgsConstructor
public class Heater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @NonNull
    private Home home;

    @NonNull
    private double power = 0;

    @Transient
    Logger logger = LoggerFactory.getLogger(Heater.class);

    public void heat() {
        power = 0;

        for (Room room : home.getRooms()) {
            if (room.getRequiredTemperature() > room.getActualTemperature() + 1) {
                power++;
                room.raiseTemperature();
            }
        }

        logger.info("Heater " + this.getId() + ": power consumption is " + this.power + " units right now.");
    }

}
