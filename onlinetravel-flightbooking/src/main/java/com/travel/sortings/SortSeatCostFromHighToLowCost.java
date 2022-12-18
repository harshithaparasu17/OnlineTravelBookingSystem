package com.travel.sortings;

import java.util.Comparator;

import com.travel.entity.FlightBooking;

public class SortSeatCostFromHighToLowCost implements Comparator<FlightBooking> {

	@Override
	public int compare(FlightBooking f1, FlightBooking f2) {
		// TODO Auto-generated method stub
		return f2.getCostPerSeat()-f1.getCostPerSeat();
	}

}
