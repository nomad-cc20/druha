package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Random;

@Data
@Entity(name = "Room")
@Table(name = "room")
@NoArgsConstructor
@RequiredArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id")
    private Home home;

    private static Random random = new Random();

    @Transient
    Logger logger = LoggerFactory.getLogger(Room.class);

    @NonNull
    private double actualTemperature = 0, requiredTemperature = 0;

    public void raiseTemperature() {
        actualTemperature++;

        logger.info("Room " + this.getId() + ": temperature changed to " + this.getActualTemperature() + " °C due to an active heating.");
    }

    public void reduceTemperature() {
        actualTemperature--;

        logger.info("Room " + this.getId() + ": temperature changed to " + this.getActualTemperature() + " °C due to an active cooling.");
    }

    public void balanceTemperature() {
        if (random.nextDouble() < 0.5)
            actualTemperature += 0.1;
        else
            actualTemperature -= 0.1;

            logger.info("Room " + this.getId() + ": temperature changed to " + this.getActualTemperature() + " °C due to natural causes.");
    }
}