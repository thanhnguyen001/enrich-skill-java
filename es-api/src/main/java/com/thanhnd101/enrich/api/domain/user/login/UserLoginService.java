package com.thanhnd101.enrich.api.domain.user.login;

import com.thanhnd101.enrich.api.service.CreateService;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.keycloak.OAuth2Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserLoginService implements CreateService<UserLoginRequest, UserLoginResponse> {


  @Override
  public UserLoginResponse execute(@NotNull UserLoginRequest userLoginRequest) {
    RestTemplate restTemplate = new RestTemplate();

    MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
    data.put("client_id", Collections.singletonList("thanhnd101-enrich-java"));
    data.put("client_secret", Collections.singletonList("mIpff0KFg4cyJ4Oyx4AaoSr0Yx7AGzZI"));
    data.put("grant_type", Collections.singletonList(OAuth2Constants.PASSWORD));
    data.put("username", Collections.singletonList(userLoginRequest.getUsername()));
    data.put("password", Collections.singletonList(userLoginRequest.getPassword()));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

    String uri = "http://localhost:8082/realms/enrich-java/protocol/openid-connect/token";

    ResponseEntity<UserLoginResponse> response = restTemplate.exchange(uri, HttpMethod.POST,
        request,
        UserLoginResponse.class);

    return response.getBody() != null ? UserLoginResponse.builder()
        .access_token(response.getBody().getAccess_token()).build()
        : UserLoginResponse.builder().access_token("").build();
  }
}
