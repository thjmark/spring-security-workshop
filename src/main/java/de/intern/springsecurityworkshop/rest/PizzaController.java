package de.intern.springsecurityworkshop.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {
	@RequestMapping(value = "/api/pizza", method = RequestMethod.GET)
	public String[] reparaturInfo() {
		String pizzaList[] = { "Salami:8€", "Magarita:6€", "Hawai: 9e" };
		return pizzaList;
	}
}
