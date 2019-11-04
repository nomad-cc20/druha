package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Random;

@Data
@Entity(name = "Room")
@Table(name = "room")
@NoArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id")
    private Home home;

    private static Random random = new Random();

    @NonNull
    private double actualTemperature = 0, requiredTemperature = 0;

    public void raiseTemperature() {
        actualTemperature++;

        log.info("Room " + this.getId() + " " + this.getActualTemperature());
    }

    public void reduceTemperature() {
        actualTemperature--;

        log.info("Room " + this.getId() + " " + this.getActualTemperature());
    }

    public void balanceTemperature() {
        if (random.nextDouble() < 0.5)
            actualTemperature += 0.1;
        else
            actualTemperature -= 0.1;

        log.info("Room " + this.getId() + " " + this.getActualTemperature());
    }
}