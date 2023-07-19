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
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Config.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  /**
   * SecurityFilterChain.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        auth -> auth.requestMatchers(HttpMethod.GET, "/api/**")
            .authenticated()
            .requestMatchers("/api/**")
            .authenticated()
            .anyRequest()
            .permitAll()
    );
    // http.cors().disable().
    http.oauth2Login(Customizer.withDefaults());
    http.oauth2ResourceServer(oauth2 -> oauth2
        .jwt(jwtCustomizer ->
            jwtCustomizer.jwtAuthenticationConverter(
                new RoleConverter())
        )
    );

    return http.build();
  }
}
