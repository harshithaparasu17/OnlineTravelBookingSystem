package com.travel.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FlightBookingDefaultDTO implements FlightBookingDTO {

	private int flightBookingId;

	private String flightName;

	private String takeOffPlace;

	private String destinationPlace;

	@NotNull(message = "Date Of Booking should not be not null")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date_of_booking")
	private Date dateOfBooking;

	@NotNull(message = "Date Of Journey should not be not null")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date_of_journey")
	private Date dateOfJourney;

	private int seatId;

	private int flightId;

	private int userId;

	private int costPerSeat;

}
