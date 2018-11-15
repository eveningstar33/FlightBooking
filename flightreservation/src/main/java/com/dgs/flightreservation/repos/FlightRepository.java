package com.dgs.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
