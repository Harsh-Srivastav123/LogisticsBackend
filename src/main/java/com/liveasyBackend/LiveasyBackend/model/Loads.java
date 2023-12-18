package com.liveasyBackend.LiveasyBackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.time.LocalDate;
import java.util.Date;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loads {
    @Id
    String shipperId= UUID.randomUUID().toString();
    @Column(nullable = false)

    String loadingPoint;
    @Column(nullable = false)
    String unloadingPoint;
    @Column(nullable = false)
    String productType;
    @Column(nullable = false)
    String truckType;
    @Column(nullable = false)
    String noOfTrucks;
    @Column(nullable = false)
    int weight;
    String Comment;
    String date;
//    @Transient
//    String user_Id;
    @ManyToOne
    @JoinColumn(name = "userDetails_Id")
    UserDetails userDetails;

}
