package com.dgs.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.flightcheckin.integration.ReservationRestClient;
import com.dgs.flightcheckin.integration.dto.Reservation;

@Controller
public class CheckInController {
	
	@Autowired
	private ReservationRestClient restClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);  
		modelMap.addAttribute("reservation", reservation); 
		return "displayReservationDetails";
	}
}
