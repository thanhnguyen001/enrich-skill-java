package com.thanhnd101.enrich.api.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.keycloak.representations.idm.CredentialRepresentation;

/**
 * Credentials Keycloak.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Credentials {
  /**
   * CredentialRepresentation.
   */
  public static CredentialRepresentation createPasswordCredentials(String password) {
    CredentialRepresentation passwordCredentials = new CredentialRepresentation();
    passwordCredentials.setTemporary(false);
    passwordCredentials.setType(CredentialRepresentation.PASSWORD);
    passwordCredentials.setValue(password);
    return passwordCredentials;
  }
}
