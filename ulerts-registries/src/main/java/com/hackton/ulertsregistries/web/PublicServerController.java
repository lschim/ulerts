package com.hackton.ulertsregistries.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.Sos;

@RestController
@RequestMapping("/publicServer")
public class PublicServerController {
	
	private static final String template = "Hello, %s!";
	 private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getCase")
   public Sos getCase(@RequestParam(value="name", defaultValue="World") String name) {
		  return new Sos(counter.incrementAndGet(),  null, null, null, String.format(template, name));
   }
	
	@RequestMapping("/putCase")
   public Sos putCase(@RequestParam(value="name", defaultValue="World") String name) {
		  return null;
   }

}
