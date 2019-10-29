package cz.upce.fei.inpda.druha.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Enumerated
    private RoleENum role;
}

