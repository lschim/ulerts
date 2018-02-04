package com.hackton.ulertsregistries.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.EmergencyCase;
import com.hackton.ulertsregistries.persistence.EmergencyCaseRepository;

@RestController
@RequestMapping("/localServer")
public class LocalServerController {

	@Autowired
	private EmergencyCaseRepository emergencyCaseRepository;

	@RequestMapping("/getCase")
	@GetMapping
	public ResponseEntity<EmergencyCase> getCase(@RequestParam(value="id") Long emergencyCaseId) {
		EmergencyCase emergencyCase = emergencyCaseRepository.findById(emergencyCaseId);
		return new ResponseEntity<>(emergencyCase, HttpStatus.OK);
	}

	@RequestMapping("/putCase")
	@PostMapping
	public ResponseEntity<EmergencyCase> putCase(@RequestParam(value = "emergencyCase") EmergencyCase emergencyCase) {
		emergencyCaseRepository.update(emergencyCase);
		return new ResponseEntity<>(emergencyCase, HttpStatus.OK);
	}

}
