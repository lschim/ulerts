package com.hackton.ulertsregistries.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.EmergencyCase;

@RestController
@RequestMapping("/localServer")
public class LocalServerController {
	
	 private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getCase")
    public EmergencyCase getCase(@RequestParam(value="id") String id) {
		  return new EmergencyCase(counter.incrementAndGet());
    }
	
	@RequestMapping("/putCase")
    public EmergencyCase putCase(@RequestParam(value="case")EmergencyCase emergencyCase) {
		  return new EmergencyCase(counter.incrementAndGet());
    }

}
