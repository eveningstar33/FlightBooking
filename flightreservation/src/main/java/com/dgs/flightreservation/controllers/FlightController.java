package com.dgs.flightreservation.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;

	@PostMapping("/findFlights")
	public String findFlights(@RequestParam String from, @RequestParam String to, 
			@RequestParam @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate) {
		flightRepository.findFlights(from, to, departureDate);
		return "displayFlights";
	}
}
