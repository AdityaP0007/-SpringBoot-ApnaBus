package com.app.ezride.repositories;

import com.app.ezride.pojo.BookingsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepo extends JpaRepository<BookingsDetails, Integer> {

}
