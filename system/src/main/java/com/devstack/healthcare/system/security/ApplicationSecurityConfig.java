package com.devstack.healthcare.system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setExposedHeaders(List.of("Authorization"));

        http.cors(cors -> cors.configurationSource(request -> corsConfiguration))
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(form -> form.defaultSuccessUrl("/home", true).permitAll())
                .logout(logout -> logout.logoutUrl("/logout").permitAll());

        return http.build();
    }
}