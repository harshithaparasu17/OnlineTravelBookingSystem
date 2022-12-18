package com.travel.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FlightDefaultDTO implements FlightDTO {

	private String flightName;
	private String flightFromCity;
	private String flightToCity;
	


}
