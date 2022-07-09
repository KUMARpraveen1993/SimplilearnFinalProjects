package com.FlyAway.Data;

public class Passenger {
	
	private int passengerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String contact;
	
	
	public int getPassengerId() {
		return passengerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public String getPassword() {
		return password;
	}


	public String getContact() {
		return contact;
	}


	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Passenger  [ passengerId= " + passengerId +", firstName= " + firstName +", lastName= " + lastName +", emailId= " + emailId +", password= " + password +", contact= " + contact +" ]";  
		
	
	}


}
