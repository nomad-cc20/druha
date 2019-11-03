package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Transient
    Logger logger = LoggerFactory.getLogger(Cooler.class);

    public void cool() {
        power = 0;

        for (Room room : home.getRooms()) {
            if (room.getRequiredTemperature() < room.getActualTemperature() - 1) {
                power--;
                room.reduceTemperature();
            }
        }

        logger.info("Cooler " + this.getId() + ": power consumption is " + this.power + " units right now.");
    }

}
