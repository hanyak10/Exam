package com.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/public/**").permitAll()  // Public URLs
                                .antMatchers("/admin/**").hasRole("ADMIN")  // Admin URLs
                                .antMatchers("/user/**").hasRole("USER")  // User URLs
                                .anyRequest().authenticated()  // Any other request requires authentication
                )

    }



}
