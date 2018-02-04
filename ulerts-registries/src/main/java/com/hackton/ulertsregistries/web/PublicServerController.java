package com.hackton.ulertsregistries.web;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackton.ulertsregistries.model.Sos;

@RestController
@RequestMapping("/publicServer")
/**
 * Routes that manages Sos. It is the global repository that is interrogated by local centrals to match a call to an Sos
 */
public class PublicServerController {
	
	 private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getSos")
   public Sos getSos(@RequestParam(value="name", defaultValue="World") String name) {
        return generateNewSos();
   }
	
	@RequestMapping("/putSos")
   public Sos putSos(@RequestParam(value="name", defaultValue="World") String name) {
		  return generateNewSos();
   }


    /**
     * Generates a Sos
     * @return
     */
   private Sos generateNewSos(){
       return new Sos(counter.incrementAndGet(),  "8199441112", 46.54567619, -72.74989097, LocalDateTime.now(), null);
   }
}
