package com.travel.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.entity.FlightBooking;

@Service
public interface FlightBookingService {
	public FlightBooking insertFlightBooking(FlightBooking flightBooking);

	public List<FlightBooking> getAllFlightBooking() throws Exception;

	public FlightBooking getFlightsByFlightBookingId(int flightBookingId) throws Exception;
	
	public FlightBooking getFlightByFlightName(String flightName) throws Exception;

	public List<FlightBooking> getFlightByDateOfBooking(Date dateOfBooking) throws Exception;

	public List<FlightBooking> getFlightByDateOfJourney(Date dateOfJourney) throws Exception;

	public List<FlightBooking> getFlightByTakeOffPlace(String takeOffPlace) throws Exception;

	public List<FlightBooking> getFlightByDestinationPlace(String destinationPlace) throws Exception;

	public List<FlightBooking> getFlightByDateOfBookingAndJourney(Date dateOfBooking, Date dateOfJourney);

	public List<FlightBooking> getFlightBetweenFlightBookingId(int range1, int range2);

	public List<FlightBooking> getFlightByDateOfBookingAndDestinationPlace(Date dateOfBooking, String destinationPlace);

	public List<FlightBooking> getFlightTakeOffPlaceAndDestinationPlace(String takeOffPlace, String destinationPlace);

	public List<FlightBooking> getFlightByCostPerSeat(int costPerSeat) throws Exception;
	
	public List<FlightBooking> filterByDestinationPlace(String destinationPlace) throws Exception;

	public List<FlightBooking> sortByCostPerSeat() throws Exception;

	public String delete(int flightBookingId);
}
