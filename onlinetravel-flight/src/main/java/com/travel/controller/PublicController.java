package com.travel.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Flight;
import com.travel.service.FlightService;

@RestController
@RequestMapping("/public/travel")
public class PublicController {

	
	@Autowired
	FlightService flightService;

	public PublicController() {
		System.out.println("\n\n\n=====>> Inside Constructor" + this);
	}

	// ResponseENtityDTO type
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
	@GetMapping("/flightName/{searchFlightName}")
	public Flight abc2(@PathVariable String searchFlightName)throws Exception
	{
		searchFlightName = searchFlightName.toLowerCase();
		
		return flightService.getFlightByFlightName(searchFlightName);
	}
	@GetMapping("/fromCity/{searchFromCity}")
	public Flight abc1(@PathVariable String searchFromCity)throws Exception
	{
		searchFromCity = searchFromCity.toLowerCase();
		return flightService.getFlightByFromCity(searchFromCity);
	}
	@GetMapping("/toCity/{searchToCity}")
	public Flight abc3(@PathVariable String searchToCity)throws Exception
	{
		searchToCity = searchToCity.toLowerCase();
		return flightService.getFlightByToCity(searchToCity);
	}
	
}
	