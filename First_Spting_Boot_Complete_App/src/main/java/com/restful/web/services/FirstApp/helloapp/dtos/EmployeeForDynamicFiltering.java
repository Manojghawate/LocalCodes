package com.restful.web.services.FirstApp.helloapp.dtos;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFilter("DynamicEmpFilter")
public class EmployeeForDynamicFiltering {
	private String name;
	private int id;
	private String entryPassword;
	private String laptopPassword;
	private String lockerPassword;
	
	public EmployeeForDynamicFiltering(String name, int id, String entryPassword, String laptopPassword,
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
