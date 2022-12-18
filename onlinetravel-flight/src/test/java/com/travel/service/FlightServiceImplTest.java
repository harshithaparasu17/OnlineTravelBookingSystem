package com.travel.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.Flight;
import com.travel.repository.FlightRepository;

@SpringBootTest
class FlightServiceImplTest {
	
	@Mock
	FlightRepository flightRepository;
	
	@InjectMocks
	FlightServiceImpl flightService;

	@Test
	@DisplayName("Test - to verify the insert operation")
	//@Displayed
	void testInsertFlight() throws Exception {
		//given
		Flight sampleInput = new Flight(1,"Indigo","Goa","Banglore",25,1000);
		Flight expectedOutput = new Flight(1,"Indigo","Goa","Banglore",25,1000);
		//Object obj = new Object();
		BDDMockito.given(flightService.insertFlight(sampleInput)).willReturn(expectedOutput);
		
		// when 
		Flight actualOutput = flightService.insertFlight(sampleInput);
		
		// verify 
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	@DisplayName("Test to verify all flight returned")
	@Disabled
	void testGetAllFlights() throws Exception {
		
		// given
		
				Flight flight1 = new Flight(1,"Indigo","Goa","Banglore",25,1000);
				flight1.setFlightName(null);
				flight1.setFromCity(null);
				flight1.setToCity(null);
				
				Flight flight2 = new Flight(2,"SpiceJet","Chennai","Hyderabad",35,1000);
				flight2.setFlightName(null);
				flight2.setFromCity(null);
				flight2.setToCity(null);
				
				
				List<Flight> sampleOutput = new ArrayList<>();
				sampleOutput.add(flight1);
				sampleOutput.add(flight2);
				
				BDDMockito.given(flightService.getAllFlights()).willReturn(sampleOutput);
				
				// ----------------------------------------------------------------------
				
				// when :- ready to test the functionality (service)
				List<Flight> actualOutput = flightService.getAllFlights();
				
				
				// then : verify the sampleOutput with actual output
				// assertThat(actualOutput).isNotNull();  // or
				assertNotNull(actualOutput);
				assertThat(actualOutput.size()).isGreaterThan(0);
				assertIterableEquals(sampleOutput, actualOutput);
				
		
	}
	/*@Test
	//@Disabled
	@DisplayName("Test to verify the method getFlight by FlightName should return Flight or not")
	void testGetFlightByFlightName() throws Exception {
		{
			// give 
			Flight sampleOutput = new Flight(1,"Indigo","Goa","Banglore",25,1000);
			sampleOutput.setFlightName("Indigo");
			
			String sampleInput = "Indigo";
			
			BDDMockito.given(flightService.getFlightByFlightName(sampleInput)).willReturn(sampleOutput);
			
			// when 
			Flight actualOutput = flightService.getFlightByFlightName(sampleInput);
			
			// verify
			assertEquals(sampleOutput,actualOutput);
			assertSame(sampleOutput.getFlightName(), actualOutput.getFlightName());
			assertThat(actualOutput.getFlightName());
		}
	}
	@Test
	//@Disabled
	@DisplayName("Test to verify the method getFlight by FromCity should return Flight or not")
	void testGetFlightByFromCity() throws Exception {
		{
			// give 
			Flight sampleOutput = new Flight(1,"Indigo","Goa","Banglore",25,1000);
		    sampleOutput.setFromCity("Goa");
						
			String sampleInput = "Goa";
						
			BDDMockito.given(flightService.getFlightByFromCity(sampleInput)).willReturn(sampleOutput);
						
			// when 
			Flight actualOutput = flightService.getFlightByFromCity(sampleInput);
						
			// verify
			assertEquals(sampleOutput,actualOutput);
			assertSame(sampleOutput.getFromCity(), actualOutput.getFromCity());
			assertThat(actualOutput.getFromCity());
		}
		
	}

	@Test
	//@Disabled
	@DisplayName("Test to verify the method getFlight by ToCity should return Flight or not")
	void testGetFlightByToCity() throws Exception {
		{
			// give 
			Flight sampleOutput = new Flight(1,"Indigo","Goa","Banglore",25,1000);
			sampleOutput.setToCity("Banglore");
						
			String sampleInput = "Banglore";
						
			BDDMockito.given(flightService.getFlightByToCity(sampleInput)).willReturn(sampleOutput);
						
			// when 
			Flight actualOutput = flightService.getFlightByToCity(sampleInput);
						
			// verify
			assertEquals(sampleOutput,actualOutput);
			assertSame(sampleOutput.getToCity(), actualOutput.getToCity());
			assertThat(actualOutput.getToCity());
		}*/
		
	/*@Test
	void testDelete() {
		fail("Not yet implemented");
	}*/

	
}

