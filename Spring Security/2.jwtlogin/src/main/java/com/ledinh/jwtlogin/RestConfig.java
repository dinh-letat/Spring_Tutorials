package com.ledinh.jwtlogin;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RestConfig {
	@Value("${jwt.public.key")
	RSAPublicKey pukey;
	
	@Value("${jwt.private.key}")
	RSAPrivateKey prkey;
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
		.csrf((csrf) -> csrf.ignoringRequestMatchers("/token"))
		.httpBasic(Customizer.withDefaults())
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
		.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.exceptionHandling((exceptions) -> exceptions
				.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
				.accessDeniedHandler(new BearerTokenAccessDeniedHandleer()));
		
		return http.build();
	}
	
	@Bean
	UserDetailsService users() {
		// @formatter:off
		return new InMemoryUserDetailsManager(
			User.withUsername("user")
				.password("{noop}password")
				.authorities("app")
				.build()
		);
		// @formatter:on
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(this.key).build();
	}

	@Bean
	JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
	}
}
