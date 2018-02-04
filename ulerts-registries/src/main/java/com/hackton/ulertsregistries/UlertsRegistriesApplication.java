package com.hackton.ulertsregistries;

import com.hackton.ulertsregistries.persistence.EmergencyCaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UlertsRegistriesApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    EmergencyCaseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UlertsRegistriesApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        logger.info("Emergency case by id 10001 -> {}", repository.findById(1));
    }
}
