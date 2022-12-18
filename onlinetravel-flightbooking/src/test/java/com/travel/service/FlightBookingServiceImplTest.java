package com.travel.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.FlightBooking;
import com.travel.repository.FlightBookingRepository;

@SpringBootTest
class FlightBookingServiceImplTest {
	@Mock
	FlightBookingRepository flightBookinRepository;

	@InjectMocks
	FlightBookingServiceImpl flightBookingService;

	@Test
	@DisplayName("Insert Operation")
	void testInsertFlightBooking() throws Exception {

		FlightBooking sampleInput = new FlightBooking("vistara", "Banglore", "mumbai", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);
		FlightBooking expectedOutput = new FlightBooking("vistara", "Banglore", "mumbai", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);
		BDDMockito.given(flightBookingService.insertFlightBooking(sampleInput)).willReturn(expectedOutput);

		// when
		FlightBooking actualOutput = flightBookingService.insertFlightBooking(sampleInput);

		// verify
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	@DisplayName("Display all flight booking")
	void testGetAllFlightBooking() throws Exception {
		FlightBooking user1 = new FlightBooking("vistara", "Banglore", "mumbai", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);

		FlightBooking user2 = new FlightBooking("vistara", "Banglore", "mumbai", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);

		List<FlightBooking> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);

		BDDMockito.given(flightBookingService.getAllFlightBooking()).willReturn(sampleOutput);
		List<FlightBooking> actualOutput = flightBookingService.getAllFlightBooking();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
	}

	@Test
	@DisplayName("Get Flights by booking Id")
	void testGetFlightsByFlightBookingId() throws Exception {
		FlightBooking sampleOutput = new FlightBooking("vistara", "Banglore", "mumbai", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);
		sampleOutput.setFlightBookingId(1);

		int sampleInput = 1;

		BDDMockito.given(flightBookingService.getFlightsByFlightBookingId(sampleInput)).willReturn(sampleOutput);

		// when
		FlightBooking actualOutput = flightBookingService.getFlightsByFlightBookingId(sampleInput);
		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getFlightBookingId(), actualOutput.getFlightBookingId());
		assertThat(actualOutput.getFlightBookingId()).isGreaterThan(0);
	}

	@Test
	@DisplayName("Display by cost per seats")
	void testGetFlightByCostPerSeat() throws Exception {
		FlightBooking flightBooking1 = new FlightBooking("vistara", "Banglore", "mumbai", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);

		FlightBooking flightBooking2 = new FlightBooking("vistara", "Banglore", "kerala", Date.valueOf("2022-11-16"),
				Date.valueOf("2022-12-07"), 108, 106, 104, 1200);

		List<FlightBooking> sampleOutput = new ArrayList<>();
		sampleOutput.add(flightBooking1);
		sampleOutput.add(flightBooking2);

		int sampleInput1 = 1200;

		BDDMockito.given(flightBookingService.getFlightByCostPerSeat(sampleInput1)).willReturn(sampleOutput);
		/// when
		List<FlightBooking> actualOutput = flightBookingService.getFlightByCostPerSeat(sampleInput1);
		// verify
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);

	}

}
