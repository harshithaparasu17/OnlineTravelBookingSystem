package com.travel.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.travel.dto.FlightDefaultDTO;
import com.travel.entity.Flight;

@Component
@Scope("singleton")
public class FlightDTOConvertor {
public static FlightDefaultDTO getFlightDefaultDTO(Flight flight)
{
	FlightDefaultDTO dto = new FlightDefaultDTO(
			flight.getFlightName(),
			flight.getFromCity(),
			flight.getToCity());
			
return dto;
	
}
}