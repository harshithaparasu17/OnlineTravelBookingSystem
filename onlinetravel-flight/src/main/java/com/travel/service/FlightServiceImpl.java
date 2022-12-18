package com.travel.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.Flight;
import com.travel.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	@Transactional
	public Flight insertFlight(Flight flight) throws Exception {
		// TODO Auto-generated method stub
		Flight savedFlight = flightRepository.save(flight);// Note : save() is already implemented by Spring Data JPA
		if (savedFlight != null) {
			return savedFlight;
		} else
		return null;
	}

	@Override
	public List<Flight> getAllFlights() throws Exception {
		// TODO Auto-generated method stub
		List<Flight> allFlights = flightRepository.findAll(); // Note : same as save
		return allFlights;
	}
	
	@Override
	public Flight getFlightByFlightName(String FlightName) throws Exception {
		Flight outputFlight = flightRepository.getFlightByFlightName(FlightName);
		
		if (outputFlight == null) {
			throw new EntityNotFoundException(FlightName + " not listed in the database");
		}else {
			return outputFlight;
		}
	
	}

	@Override
	public Flight getFlightByFromCity(String fromCity) throws Exception {
		Flight  outputFlight = flightRepository.getFlightByFromCity(fromCity);
		
		if (outputFlight == null) {
			throw new EntityNotFoundException(fromCity + " not listed in the database");
		}else {
			return outputFlight;
		}
	

	}

	@Override
	public Flight getFlightByToCity(String toCity) throws Exception {
		Flight  outputFlight = flightRepository.getFlightByToCity(toCity);
		
		if (outputFlight == null) {
			throw new EntityNotFoundException(toCity + " not listed in the database");
		}else {
			return outputFlight;
		}
	}

	@Override
	public String delete(int flightNumber)throws Exception {
		
		flightRepository.deleteById(flightNumber);
		return "OPERATION IS COMPLETED";
	}
	
   
}