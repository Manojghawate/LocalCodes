package com.restful.web.services.FirstApp.helloapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.web.services.FirstApp.helloapp.dtos.PersonV1;
import com.restful.web.services.FirstApp.helloapp.dtos.PersonV2;
/**
 * @author manoj.ghawate
 * 
 * This controller shows how we can maintain the API version.
 * 1.Maintain different urls
 * 2.Add request parameter in url.
 * 3.Maintain the custom header.
 * 4.Maintain user define MIME_TYPE and use as an accepts header in request and produces on API methods.
 * NOTE: None of the above is ideal way of API versioning each one has its own pros and cons. So we can use one of the above as per our convenience.
 */
@RestController
@RequestMapping("/api")
public class VersioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 getV1Person() {
		return new PersonV1("John Cena");
	}
	@GetMapping("/v2/person")
	public PersonV2 getV2Person() {
		return new PersonV2("John","Cena");
	}
	@GetMapping(path="/v/person",params = "version=1")
	public PersonV1 getV1PersonByRequestParam() {
		return new PersonV1("John Cena");
	}
	@GetMapping(path="/v/person",params = "version=2")
	public PersonV2 getV2PersonByRequestParam() {
		return new PersonV2("John","Cena");
	}
	@GetMapping(path="/v/person",headers="api-version=1")
	public PersonV1 getV1PersonByHeaders() {
		return new PersonV1("HJohn Cena");
	}
	@GetMapping(path="/v/person",headers="api-version=2")
	public PersonV2 getV2PersonByHeaders() {
		return new PersonV2("H2John","Cena");
	}
	@GetMapping(path="/v/person",produces="application/api-version-v1+json")
	public PersonV1 getV1PersonByAcceptHeaders() {
		return new PersonV1("HA1John Cena"); 
	}
	@GetMapping(path="/v/person",produces="application/api-version-v2+json")
	public PersonV2 getV2PersonByAcceptHeaders() {
		return new PersonV2("HA2John","Cena");
	}

}
