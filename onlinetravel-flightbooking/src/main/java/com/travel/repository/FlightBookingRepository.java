package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.entity.FlightBooking;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer>, FlightBookingCustomRepository {

}
