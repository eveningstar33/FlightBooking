package com.dgs.flightreservation.repos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	void findFlights(String from, String to, Date departureDate);  

}
