package com.travel.repository;



import org.springframework.stereotype.Repository;

import com.travel.entity.Flight;

@Repository
public interface IFlightCustomRepository {

		public Flight getFlightByFlightName(String flightName)throws Exception;
		public Flight getFlightByFromCity(String fromCity)throws Exception;
		public Flight getFlightByToCity(String toCity)throws Exception;
	


	
}