package cz.upce.fei.inpda.druha.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Home")
@Table(name = "home")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "homes")
    private List<User> users;

    @OneToOne
    private Cooler cooler;

    @OneToOne
    private Heater heater;

    @OneToMany(
            mappedBy = "home",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms;

    public void step() {
        rooms.forEach(room -> room.balanceTemperature());

        cooler.cool();
        heater.heat();
    }
}
