package com.travel.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flightbooking")
public class FlightBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public FlightBooking(Date dateOfBooking, Date dateOfJourney) {
		this.dateOfBooking = dateOfBooking;
		this.dateOfJourney = dateOfJourney;
	}

	public FlightBooking(String flightName, String takeOffPlace, String destinationPlace, Date dateOfBooking,
			Date dateOfJourney, int seatId, int flightId, int userId, int costPerSeat) {
		super();
		this.flightName = flightName;
		this.takeOffPlace = takeOffPlace;
		this.destinationPlace = destinationPlace;
		this.dateOfBooking = dateOfBooking;
		this.dateOfJourney = dateOfJourney;
		this.seatId = seatId;
		this.flightId = flightId;
		this.userId = userId;
		this.costPerSeat = costPerSeat;
	}

}
