package com.travel.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.travel.dto.FlightBookingDefaultDTO;
import com.travel.entity.FlightBooking;

@Component
@Scope("singleton")
public class FlightBookingDTOConvertor {
	public static FlightBookingDefaultDTO getFlightBookingDefaultDTO(FlightBooking flightBooking) {
		FlightBookingDefaultDTO dto = new FlightBookingDefaultDTO(flightBooking.getFlightBookingId(),
				flightBooking.getFlightName(), flightBooking.getTakeOffPlace(), flightBooking.getDestinationPlace(),
				flightBooking.getDateOfBooking(), flightBooking.getDateOfJourney(), flightBooking.getSeatId(),
				flightBooking.getFlightId(), flightBooking.getUserId(), flightBooking.getCostPerSeat());

		return dto;

	}
}
