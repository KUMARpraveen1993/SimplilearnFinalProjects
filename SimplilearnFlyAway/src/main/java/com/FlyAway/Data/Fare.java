package com.FlyAway.Data;

public class Fare {
	private int flightNumber;
	private String flightClass;
	private double fare;
	public int getFlightNumber() {
		return flightNumber;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public double getFare() {
		return fare;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	@Override
	public String toString() {
		return "Fare [ flightNumber= " + flightNumber +", flightClass= " + flightClass +", fare= " + fare +" ]" ;
		
	}

}
