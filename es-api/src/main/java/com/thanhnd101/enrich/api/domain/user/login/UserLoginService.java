package com.thanhnd101.enrich.api.domain.user.login;

import com.thanhnd101.enrich.api.service.CreateService;
import javax.security.auth.login.LoginException;
import lombok.RequiredArgsConstructor;


/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserLoginService implements CreateService<UserLoginRequest, UserLoginResponse> {


  @Override
  public UserLoginResponse execute(UserLoginRequest userLoginRequest) {

    return new UserLoginResponse();
  }
}
