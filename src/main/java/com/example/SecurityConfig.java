package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authorizeHttpRequest ->
					authorizeHttpRequest
						.requestMatchers("/actuator/**").permitAll()
						.anyRequest().authenticated()
			).x509(x509 -> x509.subjectPrincipalRegex("CN=(.*?)(?:,|$)"));
		
		return httpSecurity.build();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return userName -> this.loadByUserName(userName);
	}

	private UserDetails loadByUserName(String userName) {
		return new User(userName, "", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
	}
}
