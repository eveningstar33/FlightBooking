package com.dgs.flightcheckin.integration;

import org.springframework.web.client.RestTemplate;

import com.dgs.flightcheckin.integration.dto.Reservation;
import com.dgs.flightcheckin.integration.dto.ReservationUpdateRequest;

public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
				.getForObject(RESERVATION_REST_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return null;
	}

}
