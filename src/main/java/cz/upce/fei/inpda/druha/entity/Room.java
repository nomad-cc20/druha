package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Random;

@Data
@Entity(name = "Room")
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
    }

    public void reduceTemperature() {
        actualTemperature--;
    }

    public void balanceTemperature() {
        if (random.nextDouble() < 0.5)
            actualTemperature += 0.1;
        else
            actualTemperature -= 0.1;
    }
}