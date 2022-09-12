package com.app.ezride.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int customerId;
    private String seatNumber;

    @ManyToOne
    private Ride rideId;

    public BookingsDetails(int customerId, String seatNumber) {
        this.customerId = customerId;
        this.seatNumber = seatNumber;
    }
}
