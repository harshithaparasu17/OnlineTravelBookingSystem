package com.travel.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.FlightBooking;
@Repository
public interface FlightBookingCustomRepository {
	public FlightBooking getFlightsByFlightBookingId(int bookingId) throws Exception;

	public FlightBooking getFlightByFlightName(String flightName) throws Exception;

	public List<FlightBooking> getFlightByTakeOffPlace(String takeOffPlace) throws Exception;

	public List<FlightBooking> getFlightByDestinationPlace(String destinationPlace) throws Exception;

	public List<FlightBooking> getFlightByDateOfBooking(Date dateOfBooking) throws Exception;

	public List<FlightBooking> getFlightByDateOfJourney(Date dateOfJourney) throws Exception;

	public List<FlightBooking> getFlightByCostPerSeat(int costPerSeat) throws Exception;

	@Query("from FlightBooking where takeOffPlace = :top and destinationPlace = :dp")
	public List<FlightBooking> getFlightTakeOffPlaceAndDestinationPlace(@Param("top") String takeOffPlace,
			@Param("dp") String destinationPlace);

	@Query("from FlightBooking where flightBookingId >= :range1 and flightBookingId <= :range2")
	public List<FlightBooking> getFlightBetweenFlightBookingId(@Param("range1") int r1, @Param("range2") int r2);

	@Query("from FlightBooking where dateOfBooking = :dob and dateOfJourney= :doj")
	public List<FlightBooking> getFlightByDateOfBookingAndJourney(@Param("dob") Date dateOfBooking,
			@Param("doj") Date dateOfJourney);

	@Query("from FlightBooking where dateOfBooking = :dob and destinationPlace = :destinationPlace")
	public List<FlightBooking> getFlightByDateOfBookingAndDestinationPlace(@Param("dob") Date dateOfBooking,
			@Param("destinationPlace") String destinationPlace);

}
