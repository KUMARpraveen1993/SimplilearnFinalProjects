package com.FlyAway.Data;

public class Flight {
	private int flightNumber;
	private String airline;
	private String weekdays;
	private String source;
	private String destination;
	public int getFlightNumber() {
		return flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public String getWeekdays() {
		return weekdays;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
@Override
public String toString() {
	return "Flight [ flightNumber= " + flightNumber +", airline= " + airline +", weekdays= " + weekdays +", source= " + source +", destination= " + destination +"]";
	
}
}
