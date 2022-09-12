package com.app.ezride.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String source;
    private String destination;
    private LocalDate date;
    private LocalTime time;
    private String boardingPoint;
    private String droppingPoint;
    private int capacity;
    private double charges;
    private boolean verificationStatus = false;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    @JsonIgnore
    private Driver driverId;

    @OneToMany(mappedBy = "rideId", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<BookingsDetails> bookingsDetailsList = new ArrayList<>();


    //helper methods :
     public void addBookingDetails(BookingsDetails bookingsDetails){
         this.bookingsDetailsList.add(bookingsDetails);
         bookingsDetails.setRideId(this);
     }

     public void removeBookingDetails(BookingsDetails bookingsDetails){
         this.bookingsDetailsList.remove(bookingsDetails);
         bookingsDetails.setRideId(null);
     }

}
