package com.dgs.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dgs.flightreservation.entities.Reservation;
import com.dgs.flightreservation.repos.ReservationRepository;

// We create the Integration Layer

@RestController
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable Long id) {
		return reservationRepository.findById(id).get();
	}

}
