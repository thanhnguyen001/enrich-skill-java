package com.thanhnd101.enrich.api.security;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Security Config.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  /**
   * Handler login success.
   */
  public AuthenticationSuccessHandler keycloakSuccessHandler() {
    return new KeycloakSuccessHandler();
  }

  /**
   * SecurityFilterChain.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        auth -> auth
            .requestMatchers(HttpMethod.GET, "/api/**")
            .authenticated()
            .requestMatchers(HttpMethod.POST, "/api/users/login")
            .permitAll()
            .requestMatchers("/api/**")
            .authenticated()
            .anyRequest()
            .permitAll()
    )
        .formLogin(form -> form.successHandler(keycloakSuccessHandler()));
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

  @Bean
  Keycloak keycloakInstance() {
    return KeycloakBuilder.builder()
        .serverUrl("http://localhost:8082")
        .realm("enrich-java")
        .clientId("admin-cli")
        .grantType(OAuth2Constants.PASSWORD)
        .username("thanhnd101")
        .password("thanhnd101")
        .build();
  }
}
