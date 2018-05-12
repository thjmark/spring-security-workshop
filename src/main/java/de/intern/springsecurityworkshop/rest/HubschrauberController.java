package de.intern.springsecurityworkshop.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HubschrauberController {
	@RequestMapping(value = "/api/hubschrauber", method = RequestMethod.GET)
	public String[] reparaturInfo() {
		String reparaturen[] = { "Rotor putzen: 2000€", "Rotor ausbessern: 10000€", "Motor prüfen: 1000€", "Turbinenblätter austauschen: 500000€" };
		return reparaturen;
	}
}
