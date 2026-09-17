package com.example.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF for stateless REST endpoints
                .csrf(csrf -> csrf.disable())

                // 2. Configure endpoint authorization
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/app/v1/auth/register").permitAll() // Allow public access to registration
                        .anyRequest().authenticated()                         // Require auth for other endpoints
                )

                // 3. Enable HTTP Basic Authentication
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}