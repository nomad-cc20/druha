package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity(name = "Room")
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id")
    private Home home;

    @NonNull
    private double actualTemperature = 0, requiredTemperature = 0;

    public void raiseTemperature() {
        actualTemperature = (requiredTemperature > actualTemperature + 1 ? actualTemperature + 1 : requiredTemperature);
    }

    public void reduceTemperature() {
        actualTemperature = (requiredTemperature < actualTemperature - 1 ? actualTemperature - 1 : requiredTemperature);
    }

}