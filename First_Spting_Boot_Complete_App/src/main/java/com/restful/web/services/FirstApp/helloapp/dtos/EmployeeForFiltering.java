package com.restful.web.services.FirstApp.helloapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"laptopPassword","lockerPassword"})
public class EmployeeForFiltering {
	//change property name in response/json conversion.
	@JsonProperty("Employee_Name")
	private String name;
	private int id;
	//ignore/exclude property in response/json conversion.
	@JsonIgnore
	private String entryPassword;
	private String laptopPassword;
	private String lockerPassword;
	
	public EmployeeForFiltering(String name, int id, String entryPassword, String laptopPassword,
			String lockerPassword) {
		super();
		this.name = name;
		this.id = id;
		this.entryPassword = entryPassword;
		this.laptopPassword = laptopPassword;
		this.lockerPassword = lockerPassword;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String getEntryPassword() {
		return entryPassword;
	}
	public String getLaptopPassword() {
		return laptopPassword;
	}
	public String getLockerPassword() {
		return lockerPassword;
	}
	@Override
	public String toString() {
		return "EmployeeForFiltering [name=" + name + ", id=" + id + ", entryPassword=" + entryPassword
				+ ", laptopPassword=" + laptopPassword + ", lockerPassword=" + lockerPassword + "]";
	}
	
	
}
