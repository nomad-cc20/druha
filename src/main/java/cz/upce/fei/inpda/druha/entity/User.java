package cz.upce.fei.inpda.druha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "User")
@Table(name = "user")
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String username, password;

    @NonNull
    @Enumerated
    private RoleENum role;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "user_home",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "home_id"))
    private List<Home> homes;

}
