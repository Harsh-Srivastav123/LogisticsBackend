package com.liveasyBackend.LiveasyBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetails {
    @Id
    String userDetails_Id= UUID.randomUUID().toString();
    String userName;
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    int totalWeight;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userDetails")

    List<Loads> previousLoads;
}
