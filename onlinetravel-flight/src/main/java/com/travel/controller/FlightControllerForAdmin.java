package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Flight;
import com.travel.service.FlightService;

@RestController
@RequestMapping("/admin/travel")
public class FlightControllerForAdmin {

	@Autowired
	FlightService flightService;

	public FlightControllerForAdmin() {
		System.out.println("\n\n\n=====>> Inside Constructor" + this);
	}
	
	@PostMapping("/addflight")
public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
		
		try {
			Flight savedFlight=flightService.insertFlight(flight);
			String responseMessage=savedFlight.getFlightName()+"save with Number"+savedFlight.getFlightNumber();
			return new ResponseEntity<String>(responseMessage,HttpStatus.OK);
		} catch (Exception e) {
			String errorMessage="Contact to customer care 1800-250-960 or mail us :- care@travel.com";
			return new ResponseEntity<String>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
	
		try {
			List<Flight> allExtractedFlights = flightService.getAllFlights();
			return allExtractedFlights;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@GetMapping("/flightName/{searchFlightname}")
	public Flight abc1(@PathVariable String searchFlightName)throws Exception
	{
		return flightService.getFlightByFlightName(searchFlightName);
	}
//	@GetMapping("/fromCity/{searchfromCity}")
//	public Flight abc2(@PathVariable String searchfromCity)throws Exception
//	{
//		return flightService.getFlightByFromCity(searchfromCity);
//	}
//	@GetMapping("/toCity/{searchtoCity}")
//	public Flight abc3(@PathVariable String searchtoCity)throws Exception
//	{
//		return flightService.getFlightByToCity(searchtoCity);
//	}
	@DeleteMapping("/flightnumber/{searchFlightNumber}")
	public String deleteFlight(@PathVariable int searchFlightNumber)
	{
		try {
			flightService.delete(searchFlightNumber);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "FlightDeletedSuccessfully";
		
	}
	
	
	

}