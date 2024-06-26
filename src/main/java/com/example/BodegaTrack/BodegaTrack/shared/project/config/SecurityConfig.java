package com.example.BodegaTrack.BodegaTrack.shared.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF (solo para desarrollo, no se recomienda en producción)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/login", "/api/v1/customers", "/api/v1/grocers", "/api/v1/grocer-customers", "/api/v1/movements", "api/v1/payments").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/grocers/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/grocers").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/grocers/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/grocers/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/customers/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/customers").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/customers/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/customers/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/grocer-customers/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/grocer-customers").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/grocer-customers/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/grocer-customers/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/movements/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/movements").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/movements/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/movements/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/payments/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/payments").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/payments/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/payments/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
