package de.intern.springsecurityworkshop.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
	@RequestMapping(value = "/api/info", method = RequestMethod.GET)
	public InfoDto basicInfo(@RequestParam(name = "username", defaultValue = "pizzaKunde") String user) {
		switch (user) {
		case "hubschrauberKunde":
			return new InfoDto("Wir machen Hubschrauberreparaturen.", "/api/hubschrauber");
		case "chef":
			return new InfoDto("Hallo Chef.", "/api/chef");
		case "pizzaKunde":
			return new InfoDto("Bei uns gibt es Pizza.", "/api/pizza");
		default:
			return new InfoDto("Du gehörtst hier nicht hin du Einbrecher.", "api/error");
		}
	}
}
