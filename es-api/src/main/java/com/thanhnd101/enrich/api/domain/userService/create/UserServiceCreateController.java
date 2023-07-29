package com.thanhnd101.enrich.api.domain.userService.create;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * service controller create user.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-service")
public class UserServiceCreateController {

  private final UserServiceCreateService userServiceCreateService;

  @PostMapping
  public ResponseEntity<UserServiceCreateResponse> create(
      @RequestBody UserServiceCreateRequest userServiceCreateRequest) {
    return ResponseEntity.ok(userServiceCreateService.execute(userServiceCreateRequest));
  }
}
