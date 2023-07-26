package com.thanhnd101.enrich.api.domain.user.update;

import com.thanhnd101.enrich.api.security.Credentials;
import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.UserRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserUpdateService implements CreateService<UserUpdateRequest, UserUpdateResponse> {

  private final UserRepository userRepository;

  private final Keycloak keycloak;

  @Override
  public UserUpdateResponse execute(UserUpdateRequest userUpdateRequest) {
    CredentialRepresentation credential = Credentials
        .createPasswordCredentials(userUpdateRequest.getPassword());

    RealmResource realmResource = keycloak.realm("enrich-java");
    UserRepresentation userRepresentation = realmResource.users().search(userUpdateRequest.getUsername()).get(0);
    userRepresentation.setUsername(userUpdateRequest.getUsername());
    userRepresentation.setEmail(userUpdateRequest.getEmail());
    userRepresentation.setCredentials(Collections.singletonList(credential));
    userRepresentation.setEnabled(true);
    String userId = userRepresentation.getId();
    UserResource userResource = realmResource.users().get(userId);
    userResource.update(userRepresentation);

    User user = userUpdateRequest.convertToUser();
    UserUpdateResponse userResponse = UserUpdateResponse.of(user);
    userRepository.update(user);

    keycloak.close();
    return userResponse;
  }
}

