package com.hackton.ulertsregistries.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/putCase", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<EmergencyCase> putCase(@RequestBody EmergencyCase emergencyCase) {
		emergencyCaseRepository.insert(emergencyCase);
		return new ResponseEntity<>(emergencyCase, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCaseList", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<EmergencyCase>> getCases() {
		return new ResponseEntity<>(emergencyCaseRepository.findAll(), HttpStatus.OK);
	}

}
