package com.thanhnd101.enrich.api.domain.user.create;

import com.thanhnd101.enrich.api.security.Credentials;
import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.UserRepository;
import jakarta.ws.rs.core.Response;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserCreateService implements CreateService<UserCreateRequest, UserCreateResponse> {

  private final UserRepository userRepository;

  private final Keycloak keycloak;

  @Override
  public UserCreateResponse execute(UserCreateRequest userCreateRequest) {
    CredentialRepresentation credential = Credentials
        .createPasswordCredentials(userCreateRequest.getPassword());

    UserRepresentation userRepresentation = new UserRepresentation();
    userRepresentation.setUsername(userCreateRequest.getUsername());
    userRepresentation.setEmail(userCreateRequest.getEmail());
    userRepresentation.setCredentials(Collections.singletonList(credential));

    userRepresentation.setEnabled(true);
    RealmResource realmResource = keycloak.realm("enrich-java");
    Response response = realmResource.users().create(userRepresentation);

    String userId = CreatedResponseUtil.getCreatedId(response);
    UserResource userResource = realmResource.users().get(userId);

    // Get realm roles (requires view-realm role)
    String role = Boolean.TRUE.equals(userCreateRequest.getIsAdmin()) ? "Admin" : "User";
    RoleRepresentation realmUserRole = realmResource.roles()//
        .get(role).toRepresentation();

    // Assign realm role tester to user
    userResource.roles().realmLevel() //
        .add(Collections.singletonList(realmUserRole));

    keycloak.close();

    // Add User to DB
    User user = userCreateRequest.convertToUser();
    UserCreateResponse userResponse = UserCreateResponse.of(user);
    userRepository.create(user);

    return userResponse;
  }
}
