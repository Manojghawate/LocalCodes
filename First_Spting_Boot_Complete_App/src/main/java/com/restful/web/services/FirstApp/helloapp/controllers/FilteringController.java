package com.restful.web.services.FirstApp.helloapp.controllers;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restful.web.services.FirstApp.helloapp.dtos.EmployeeForDynamicFiltering;
import com.restful.web.services.FirstApp.helloapp.dtos.EmployeeForFiltering;

@RestController
@RequestMapping("/api/filtering")
public class FilteringController {
	@GetMapping
	public EmployeeForFiltering filter() {
		return new EmployeeForFiltering("John", 10, "J1", "J2", "J3");
	}
	
	@GetMapping("/dynamic/one")
	public MappingJacksonValue dynamicFilter() {
		EmployeeForDynamicFiltering emp = new EmployeeForDynamicFiltering("John", 10, "J1", "J2", "J3");
		MappingJacksonValue mjv = new MappingJacksonValue(emp);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicEmpFilter", filter);
		mjv.setFilters(filterProvider);
		return mjv;
	}
	@GetMapping("/dynamic/two")
	public MappingJacksonValue dynamicFilter2() {
		EmployeeForDynamicFiltering emp = new EmployeeForDynamicFiltering("John", 10, "J1", "J2", "J3");
		MappingJacksonValue mjv = new MappingJacksonValue(emp);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","id");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicEmpFilter", filter);
		mjv.setFilters(filterProvider);
		return mjv;
	}


}
