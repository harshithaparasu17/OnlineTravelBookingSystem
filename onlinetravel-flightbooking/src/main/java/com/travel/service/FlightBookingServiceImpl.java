package com.travel.service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.FlightBooking;
import com.travel.repository.FlightBookingRepository;
import com.travel.sortings.SortSeatCostFromHighToLowCost;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {
	@Autowired
	FlightBookingRepository flightBookingRepository;

	@Override
	public FlightBooking insertFlightBooking(FlightBooking flightBooking) {
		FlightBooking savedFlightBooking = flightBookingRepository.save(flightBooking);

		if (savedFlightBooking != null) {
			return savedFlightBooking;
		} else
			return null;

	}

	@Override
	public List<FlightBooking> getAllFlightBooking() throws Exception {
		List<FlightBooking> allUsers = flightBookingRepository.findAll(); // Note : same as save
		return allUsers;
	}

	@Override
	public FlightBooking getFlightsByFlightBookingId(int flightBookingId) throws Exception {
		return flightBookingRepository.getFlightsByFlightBookingId(flightBookingId);
	}

	@Override
	public List<FlightBooking> getFlightByDateOfBooking(Date dateOfBooking) throws Exception {
		return flightBookingRepository.getFlightByDateOfBooking(dateOfBooking);
	}

	@Override
	public List<FlightBooking> getFlightByDateOfJourney(Date dateOfJourney) throws Exception {
		return flightBookingRepository.getFlightByDateOfJourney(dateOfJourney);
	}

	@Override
	public String delete(int flightBookingId) {
		flightBookingRepository.deleteById(flightBookingId);
		return "Deleted successfully";
	}

	@Override
	public List<FlightBooking> getFlightByCostPerSeat(int costPerSeat) throws Exception {
		return flightBookingRepository.getFlightByCostPerSeat(costPerSeat);
	}

	@Override
	public List<FlightBooking> getFlightBetweenFlightBookingId(int range1, int range2) {
		return flightBookingRepository.getFlightBetweenFlightBookingId(range1, range2);
	}

	@Override
	public List<FlightBooking> getFlightByDateOfBookingAndJourney(Date dateOfBooking, Date dateOfJourney) {
		return flightBookingRepository.getFlightByDateOfBookingAndJourney(dateOfBooking, dateOfJourney);
	}

	@Override
	public List<FlightBooking> sortByCostPerSeat() throws Exception {
		List<FlightBooking> list = flightBookingRepository.findAll();
		Collections.sort(list, new SortSeatCostFromHighToLowCost());
		return list;
	}

	@Override
	public List<FlightBooking> getFlightByTakeOffPlace(String takeOffPlace) throws Exception {
		return flightBookingRepository.getFlightByTakeOffPlace(takeOffPlace);
	}

	@Override
	public List<FlightBooking> getFlightByDestinationPlace(String destinationPlace) throws Exception {
		List<FlightBooking> outputDestination = flightBookingRepository.getFlightByDestinationPlace(destinationPlace);
		if (outputDestination == null) {
			throw new EntityNotFoundException(destinationPlace + " not listed in the database");
		} else {
			return outputDestination;
		}

	}

	@Override
	public List<FlightBooking> getFlightByDateOfBookingAndDestinationPlace(Date dateOfBooking,
			String destinationPlace) {
		return flightBookingRepository.getFlightByDateOfBookingAndDestinationPlace(dateOfBooking, destinationPlace);
	}

	@Override
	public List<FlightBooking> getFlightTakeOffPlaceAndDestinationPlace(String takeOffPlace, String destinationPlace) {
		return flightBookingRepository.getFlightTakeOffPlaceAndDestinationPlace(takeOffPlace, destinationPlace);
	}

	@Override
	public List<FlightBooking> filterByDestinationPlace(String destinationPlace) throws Exception {
		List<FlightBooking> filterDestination = getAllFlightBooking().stream()
				.filter((dp) -> dp.getDestinationPlace().equals(destinationPlace)).collect(Collectors.toList());
		return filterDestination;
	}

	@Override
	public FlightBooking getFlightByFlightName(String flightName) throws Exception {
		return flightBookingRepository.getFlightByFlightName(flightName);
	}

}
