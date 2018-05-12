package de.intern.springsecurityworkshop.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	@RequestMapping(value = "/api/error", method = RequestMethod.GET)
	public String reparaturInfo() {
		return "Schäm dich! Was würde deine Mutter sagen!";
	}
}
