package com.travel.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.dto.FlightBookingDTO;
import com.travel.dto.FlightBookingDefaultDTO;
import com.travel.entity.FlightBooking;
import com.travel.service.FlightBookingService;
import com.travel.util.FlightBookingDTOConvertor;

@RestController
@RequestMapping("/flightbooking/admin")
@Validated
public class FlightBookingAdminController {
	@Autowired
	FlightBookingService flightBookingService;

	public FlightBookingAdminController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}

	@GetMapping("/allflightbooking") // localhost:8023/flightbooking/admin/allflightbooking
	public List<FlightBooking> getAllFlightBooking() {
		try {
			List<FlightBooking> allExtractedUsers = flightBookingService.getAllFlightBooking();
			return allExtractedUsers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@GetMapping("/searchbooking/{flightBookingId}") // localhost:8023/flightbooking/admin/searchbooking/1
	public FlightBooking searchBooking(@PathVariable int flightBookingId) throws Exception {
		return flightBookingService.getFlightsByFlightBookingId(flightBookingId);
	}

	@GetMapping("/dateofbooking/{dateOfBooking}") // localhost:8023/flightbooking/admin/dateofbooking/2022-11-13
	public List<FlightBooking> searchDateOfBooking(@PathVariable Date dateOfBooking) throws Exception {
		return flightBookingService.getFlightByDateOfBooking(dateOfBooking);
	}

	@GetMapping("/dateofjourney/{dateOfJourney}") // localhost:8023/flightbooking/admin/dateofjourney/2022-11-13
	public List<FlightBooking> searchDateOfJourney(@PathVariable Date dateOfJourney) throws Exception {
		return flightBookingService.getFlightByDateOfJourney(dateOfJourney);
	}

	@GetMapping("/flightbookingbyid") // localhost:8023/flightbooking/admin/flightbookingbyid?r1=1&r2=4
	public List<FlightBooking> flightBookingBetweenId(@RequestParam int r1, @RequestParam int r2) throws Exception {
		return flightBookingService.getFlightBetweenFlightBookingId(r1, r2);
	}

	@GetMapping("/takeoffplace/{takeOffPlace}") // localhost:8023/flightbooking/admin/destinationplace/mumbai
	public List<FlightBooking> searchByTakeOffPlace(@PathVariable String takeOffPlace) throws Exception {
		return flightBookingService.getFlightByTakeOffPlace(takeOffPlace);
	}

	@GetMapping("/destinationplace/{destinationPlace}") // localhost:8023/flightbooking/admin/destinationplace/madurai
	public List<FlightBooking> searchByDestinationPlace(@PathVariable String destinationPlace) throws Exception {
		return flightBookingService.getFlightByDestinationPlace(destinationPlace);
	}

	@GetMapping("/dobanddestination") // localhost:8023/flightbooking/admin/dobanddestination?dob=2022-11-01&destinationPlace=madurai
	public List<FlightBooking> flightBookingByDestinationPlaceAndDob(@RequestParam Date dob,
			@RequestParam String destinationPlace) throws Exception {
		return flightBookingService.getFlightByDateOfBookingAndDestinationPlace(dob, destinationPlace);
	}

	@GetMapping("/takeoffanddestination") // localhost:8023/flightbooking/admin/takeoffanddestination?takeOffPlace=chennai&destinationPlace=kerala
	public List<FlightBooking> flightBookingByTakeOffPlaceAndDestinationPlace(@RequestParam String takeOffPlace,
			@RequestParam String destinationPlace) throws Exception {
		return flightBookingService.getFlightTakeOffPlaceAndDestinationPlace(takeOffPlace, destinationPlace);
	}

	@GetMapping("/flightbookingbydate") // localhost:8023/flightbooking/admin/flightbookingbydate?dob=2022-11-16&doj=2022-12-07
	public List<FlightBooking> flightBookingBetweendates(@RequestParam Date dob, @RequestParam Date doj)
			throws Exception {
		return flightBookingService.getFlightByDateOfBookingAndJourney(dob, doj);
	}

	@GetMapping("/filterdestination/{destinationPlace}") // localhost:8023/flightbooking/admin/filterdestination/madurai
	public List<FlightBooking> filterDestination(@PathVariable String destinationPlace) throws Exception {
		List<FlightBooking> filtered = flightBookingService.filterByDestinationPlace(destinationPlace);
		return filtered;
	}

	@GetMapping("/flighthname/{flightName}") // localhost:8023/flightbooking/flighthname/Vistara
	public FlightBooking searchFlightName(@PathVariable String flightName) throws Exception {
		return flightBookingService.getFlightByFlightName(flightName);
	}

	@GetMapping("/flightname/{flightsName}")
	public ResponseEntity<FlightBookingDTO> getFlightByName(@PathVariable String flightsName) throws Exception {
		FlightBooking flight = flightBookingService.getFlightByFlightName(flightsName);
		FlightBookingDefaultDTO dto = FlightBookingDTOConvertor.getFlightBookingDefaultDTO(flight);
		return new ResponseEntity<FlightBookingDTO>(dto, HttpStatus.OK);
	}

}
