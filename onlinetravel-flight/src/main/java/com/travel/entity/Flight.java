package com.travel.entity;

import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int flightNumber;
	private String flightName;
	private String fromCity;
	private String toCity;
	private int noOfSeats;
	private int costPerSeat;
	
	public Flight(int flightNumber, String flightName, String fromCity, String toCity, int noOfSeats,
			int costPerSeat) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.noOfSeats = noOfSeats;
		this.costPerSeat = costPerSeat;
	}
	
	
	
	
	
}
