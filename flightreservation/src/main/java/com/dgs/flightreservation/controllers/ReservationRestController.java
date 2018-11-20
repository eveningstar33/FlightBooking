package com.dgs.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgs.flightreservation.dto.ReservationUpdateRequest;
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
	
	@PutMapping("/reservations")
	public Reservation updateReservation(ReservationUpdateRequest request) {
		
		/*
		  We are creating this 'request' because we don't want to pass in the entire reservation to do this update.
		  The client need not pass in the entire reservation. Simply he'll use this ReservationUpdateRequest wrapper 
		  and he'll pass in these 3 fields id, checkIn, numberOfBags and he will do the update on the reservation.
		*/
		
		Reservation reservation = reservationRepository.findById(request.getId()).get();  
		reservation.setCheckedIn(request.getCheckIn()); 
		reservation.setNumberOfBags(request.getNumberOfBags()); 
		return reservationRepository.save(reservation); 
	}

}
