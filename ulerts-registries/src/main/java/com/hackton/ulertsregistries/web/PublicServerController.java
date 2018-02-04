package com.hackton.ulertsregistries.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.Ulert;

@RestController
@RequestMapping("/publicServer")
public class PublicServerController {
	
	private static final String template = "Hello, %s!";
	 private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getUlert")
   public Ulert getUlert(@RequestParam(value="name", defaultValue="World") String name) {
		  return new Ulert(counter.incrementAndGet(),  null, null, null, String.format(template, name));
   }
	
	@RequestMapping("/putUlert")
   public Ulert putUlert(@RequestParam(value="name", defaultValue="World") String name) {
		  return null;
   }

}
