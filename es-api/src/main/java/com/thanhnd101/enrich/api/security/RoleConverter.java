package com.thanhnd101.enrich.api.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Role Converter.
 */
@Component
public class RoleConverter implements Converter<Jwt, AbstractAuthenticationToken> {

  /**
   * Prefix used in combination with the resource (client) name for resource level roles.
   */
  public static final String PREFIX_RESOURCE_ROLE = "ROLE_";

  /**
   * Name of the claim containing the realm level roles.
   */
  private static final String CLAIM_REALM_ACCESS = "realm_access";

  /**
   * Extracts the realm and resource level roles from a JWT token distinguishing between them using
   * prefixes.
   */
  @Override
  public AbstractAuthenticationToken convert(Jwt jwt) {
    // Collection that will hold the extracted roles
    Collection<GrantedAuthority> grantedAuthorities = extractAuthorities(jwt);

    return new JwtAuthenticationToken(jwt, grantedAuthorities);
  }

  /**
   * extract Authorities.
   */
  public Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
    if (jwt.getClaim(CLAIM_REALM_ACCESS) != null) {
      // Realm roles
      // Get the part of the access token that holds the roles assigned on realm level
      Map<String, Collection<String>> realmAccess = jwt.getClaim(CLAIM_REALM_ACCESS);

      ObjectMapper mapper = new ObjectMapper();

      List<String> roles = mapper.convertValue(realmAccess.get("roles"),
          new TypeReference<>() {
          });
      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

      for (String role : roles) {
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
      }
    }
    return new ArrayList<>();
  }
}
