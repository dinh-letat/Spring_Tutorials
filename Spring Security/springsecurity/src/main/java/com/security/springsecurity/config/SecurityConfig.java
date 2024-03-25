package com.security.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// Phân quyền truy cập
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
			.authorizeHttpRequests((authorize) -> 
				authorize.anyRequest().authenticated())
			.formLogin(form -> 
					form
						.loginPage("/login")
						.permitAll());
		return httpSecurity.build();
		
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//										.username("dinh")
//										.password("admin")
//										.roles("ADMIN")
//										.build();
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails userDetails = User.builder()
									.username("dinh")
									.password("{noop}1234")
									.roles("ADMIN", "USER", "EMPLOYEE")
									.build();
		return new InMemoryUserDetailsManager(userDetails);
	}
}
