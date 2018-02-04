package com.hackton.ulertsregistries.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.Case;

@RestController
@RequestMapping("/localServer")
public class LocalServerController {
	
	 private static final String template = "Hello, %s!";
	 private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getCase")
    public Case getCase(@RequestParam(value="name", defaultValue="World") String name) {
		  return new Case(counter.incrementAndGet(),  String.format(template, name));
    }
	
	@RequestMapping("/putCase")
    public Case putCase(@RequestParam(value="name", defaultValue="World") String name) {
		  return new Case(counter.incrementAndGet(),  String.format(template, name));
    }

}
