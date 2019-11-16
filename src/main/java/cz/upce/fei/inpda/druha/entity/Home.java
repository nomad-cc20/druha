package cz.upce.fei.inpda.druha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Home")
@Table(name = "home")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "homes")
    private List<User> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cooler cooler;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Heater heater;

    @OneToMany(
            mappedBy = "home",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Room> rooms;

    public void step() {
        rooms.forEach(Room::balanceTemperature);

        cooler.cool();
        heater.heat();
    }
}
