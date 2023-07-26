package com.thanhnd101.enrich.api.domain.user.login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller login user.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/login")
public class UserLoginController {

  private final UserLoginService userLoginService;

  @PostMapping()
  public ResponseEntity<UserLoginResponse> userLogin(
      @RequestBody UserLoginRequest userLoginRequest) {
    return ResponseEntity.ok(userLoginService.execute(userLoginRequest));
  }
}
