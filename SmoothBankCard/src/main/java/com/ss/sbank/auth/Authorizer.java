package com.ss.sbank.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class Authorizer extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers("/h2/*")
				.permitAll().antMatchers("/cardTypes").permitAll().antMatchers("/cardRecords").permitAll();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("*");
		registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
	}

}
