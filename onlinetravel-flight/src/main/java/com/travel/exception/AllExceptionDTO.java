package com.travel.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllExceptionDTO {


	private String flightName;
	private String flightFromCity;
	private String flightToCity;
	
	


}

