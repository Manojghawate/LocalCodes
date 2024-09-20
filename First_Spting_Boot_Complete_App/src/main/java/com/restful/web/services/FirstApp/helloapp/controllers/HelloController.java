package com.restful.web.services.FirstApp.helloapp.controllers;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello-app/")
public class HelloController {
	private MessageSource messageSource;
	public HelloController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@GetMapping("/hello-world/{name}")
	public String getHelloWorld(@PathVariable ("name")String name){
		return String.format("Hello,%s %s", name, "!!");
	}
	@GetMapping("/i18n")
	public String getHelloWorldi18n(){
		Locale locale = LocaleContextHolder.getLocale();
		return this.messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

}
