package de.intern.springsecurityworkshop.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BilanzController {
	@RequestMapping(value = "/api/chef", method = RequestMethod.GET)
	public String[] reparaturInfo() {
		String bilanzen[] = { "Pizza Einnahmen: 5000€", "Pizza Ausgaben : 4000€", "Hubschrauber Einnahmen: 50000€", "Hubschrauber Ausgaben:46000€ " };
		return bilanzen;
	}
}
