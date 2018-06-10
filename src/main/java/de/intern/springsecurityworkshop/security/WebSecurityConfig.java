package de.intern.springsecurityworkshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http.logout().logoutUrl("/myLogout")
		.logoutSuccessUrl("/login")
		.logoutSuccessHandler(new SimpleUrlLogoutSuccessHandler())
		.invalidateHttpSession(true)
		.addLogoutHandler(new SecurityContextLogoutHandler())
		.and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
	}

	// Plain text Passwörter sind nur für Demozwecke ok
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		manager.createUser(User.withDefaultPasswordEncoder().username("Fred").password("fred").roles("CHEF").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("Peter").password("peter").roles("PIZZA_KUNDE").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("Jutta").password("jutta").roles("PIZZA_KUNDE").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("Erna").password("erna").roles("HUBSCHRAUBER_KUNDE").build());
		return manager;
	}
}