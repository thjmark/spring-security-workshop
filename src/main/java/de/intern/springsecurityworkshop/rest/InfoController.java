package de.intern.springsecurityworkshop.rest;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
	@RequestMapping(value = "/api/info", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	public InfoDto basicInfo(Authentication auth, Principal principal) {
		List<String> roles = auth.getAuthorities().stream().map(role -> role.getAuthority()).collect(Collectors.toList());
		System.out.println(principal.getName());
		String user = roles.get(0);
		System.out.println(user);
		switch (user) {
		case "ROLE_HUBSCHRAUBER_KUNDE":
			return new InfoDto("Wir machen Hubschrauberreparaturen.", "/api/hubschrauber");
		case "ROLE_CHEF":
			return new InfoDto("Hallo Chef.", "/api/chef");
		case "ROLE_PIZZA_KUNDE":
			return new InfoDto("Bei uns gibt es Pizza.", "/api/pizza");
		default:
			return new InfoDto("Du gehörtst hier nicht hin du Einbrecher.", "api/error");
		}
	}
}
