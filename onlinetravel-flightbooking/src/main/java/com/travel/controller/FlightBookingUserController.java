package com.travel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.FlightBooking;
import com.travel.service.FlightBookingService;

@RestController
@RequestMapping("/flightbooking/user")
public class FlightBookingUserController {
	@Autowired
	FlightBookingService flightBookingService;
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	public FlightBookingUserController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}

	@PostMapping("/addflightbooking") // localhost:8023/flightbooking/user/addflightbooking
	public ResponseEntity<String> addUser(@RequestBody @Valid FlightBooking flightBooking) {

		try {
			FlightBooking savedFlight = flightBookingService.insertFlightBooking(flightBooking);
			String responseMsg = savedFlight.getFlightName() + " save with Id " + savedFlight.getFlightId();
			mylogs.info(" ---->> Inside App User Constroller Post mapping , user created " + responseMsg);
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			mylogs.error(errorMsg);
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{flightBookingId}") // localhost:8023/flightbooking/user/delete/5
	public String deleteUser(@PathVariable int flightBookingId) {

		try {
			flightBookingService.delete(flightBookingId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted successfully";
	}

	@PutMapping("/update/{flightBookingId}") // localhost:8023/flightbooking/user/update
	public FlightBooking updateFlightBooking(@PathVariable int flightBookingId,
			@RequestBody FlightBooking flightBookingDetails) throws Exception {
		flightBookingService.getFlightsByFlightBookingId(flightBookingId);
		flightBookingDetails.setFlightBookingId(flightBookingId);
		FlightBooking updateFlightBooking = flightBookingService.insertFlightBooking(flightBookingDetails);
		return updateFlightBooking;
	}

	@GetMapping("/costofseat/{costPerSeat}") // localhost:8023/flightbooking/user/costofseat/1300
	public List<FlightBooking> searchCostPerSeat(@PathVariable int costPerSeat) throws Exception {
		return flightBookingService.getFlightByCostPerSeat(costPerSeat);
	}

	@GetMapping("/cost") // localhost:8023/flightbooking/user/cost
	public List<FlightBooking> sortcostperseat() throws Exception {
		return flightBookingService.sortByCostPerSeat();
	}

}
