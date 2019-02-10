package com.bookyourticket.booking.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookyourticket.booking.entity.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Integer> {
} 
