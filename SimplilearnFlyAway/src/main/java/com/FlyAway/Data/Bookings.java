package com.FlyAway.Data;

import java.util.Date;

public class Bookings {
	
	private int bookingId;
	private int flightNumber;
	private String travelClass;
	private Date travelDate;
	private int passenger;
	private double totalFare;
	private int passengerId;
	
	public Bookings() {
		super();
		
	}
	
	public Bookings(int flightNumber, String travelClass, Date travelDate, int passenger, double totalFare, int passengerId) {
		super();
		this.flightNumber = flightNumber;
		this.travelClass = travelClass;
		this.travelDate = travelDate;
		this.passenger = passenger;
		this.totalFare = totalFare;
		this.passengerId = passengerId;
		
		
	}

	public int getBookingId() {
		return bookingId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public int getPassenger() {
		return passenger;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	
@Override
public String toString() {
	return "Bookings [ bookingId= " + bookingId +", flightNumber= " + flightNumber +", travelClass= " + travelClass +", travelDate= " + travelDate +", passenger= " + passenger +", totalFare= " + totalFare +", passengerId= " + passengerId +" ]";
	
}
} 
