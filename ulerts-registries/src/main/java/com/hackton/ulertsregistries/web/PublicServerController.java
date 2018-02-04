package com.hackton.ulertsregistries.web;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.Sos;
import com.hackton.ulertsregistries.service.MatchedSos;

/**
 * Routes that manages Sos. It is the global repository that is interrogated by local centrals to match a call to an Sos
 */
@RestController
@RequestMapping("/publicServer")
public class PublicServerController {
	
    private final AtomicLong counter = new AtomicLong();

    /**
     * Search a Sos that could be matching, and returns it with a given fiability.
     * Returns null if no Sos is matching
     * @param phoneNumber
     * @param
     * @return
     */
	@RequestMapping("/searchSos")
    @GetMapping
    public ResponseEntity<MatchedSos> searchSos(@RequestParam(value="phoneNumber") String phoneNumber,
                                                @RequestParam(value="phoneCallDate") String phoneCallDate,
                                                @RequestParam(value="longitude") Double latitude,
                                                @RequestParam(value="longitude") Double longitude
                         ) {
        return new ResponseEntity<>(new MatchedSos(generateNewSos(), (int)(Math.random()*100+1)), HttpStatus.OK);
    }

    @RequestMapping("/getSos")
    @GetMapping
    public ResponseEntity<Sos> getSos(@RequestParam(value="id") String id) {
        return new ResponseEntity<>(generateNewSos(), HttpStatus.OK);
    }


    @RequestMapping("/putSos")
    @PostMapping
    public ResponseEntity<Sos> putSos(@RequestParam(value="phoneNumber") String phoneNumber,
                      @RequestParam(value="phoneCallDate") String phoneCallDate,
                      @RequestParam(value="longitude") Double latitude,
                      @RequestParam(value="longitude") Double longitude
    ) {
        return new ResponseEntity<>(generateNewSos(), HttpStatus.OK);
    }


    /**
     * Generates a Sos
     * @return
     */
   private Sos generateNewSos(){
       return new Sos(counter.incrementAndGet(),  "8199441112", 46.54567619, -72.74989097, LocalDateTime.now(), null);
   }
}
