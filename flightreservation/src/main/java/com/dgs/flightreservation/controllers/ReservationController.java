package com.dgs.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.flightreservation.entities.Flight;
import com.dgs.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get(); 
		modelMap.addAttribute("flight", flight); 
		return "completeReservation";
	}
}
