package com.thanhnd101.enrich.api.domain.userService.delete;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller delete user.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-service")
public class UserServiceDeleteController {

  private final UserServiceDeleteService userServiceDeleteService;

  @DeleteMapping
  @PreAuthorize("hasRole('Admin')")
  public ResponseEntity<UserServiceDeleteResponse> delete(
      @RequestBody UserServiceDeleteRequest userServiceDeleteRequest) {
    return ResponseEntity.ok(userServiceDeleteService.execute(userServiceDeleteRequest));
  }
}
