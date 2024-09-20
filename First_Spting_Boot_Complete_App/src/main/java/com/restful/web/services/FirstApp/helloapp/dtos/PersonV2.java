package com.restful.web.services.FirstApp.helloapp.dtos;

public class PersonV2 {
	private String firstName;
	private String LastName;
	
	public PersonV2(String firstName, String lastName) {
		this.firstName = firstName;
		LastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonV2 [firstName=" + firstName + ", LastName=" + LastName + "]";
	}
	
}
