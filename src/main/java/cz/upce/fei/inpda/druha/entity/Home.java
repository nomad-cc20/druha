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
    private Home home;

    @NonNull
    private int roomsCount;

    @OneToMany(
            mappedBy = "home",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms;

}
