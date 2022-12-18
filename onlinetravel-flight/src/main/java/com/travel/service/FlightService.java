package com.travel.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.travel.entity.Flight;

@Service
public interface FlightService {

	public Flight insertFlight(Flight flight)throws Exception;
	public List<Flight> getAllFlights()throws Exception;
	public Flight getFlightByFlightName(String flightName)throws Exception;
	public Flight getFlightByFromCity(String searchFromCity)throws Exception;
	public Flight getFlightByToCity(String searchToCity)throws Exception;
	public String delete(int searchFlightNumber) throws Exception;
	
	

	
	


}