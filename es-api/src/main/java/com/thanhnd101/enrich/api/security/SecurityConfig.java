package com.thanhnd101.enrich.api.security;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .requestMatchers("/api/users")
        .authenticated()
        .anyRequest()
        .permitAll();

    http.oauth2Login(Customizer.withDefaults());
    http.oauth2ResourceServer((oauth2) -> oauth2
        .jwt(Customizer.withDefaults())
    );

    return http.build();
  }
}
