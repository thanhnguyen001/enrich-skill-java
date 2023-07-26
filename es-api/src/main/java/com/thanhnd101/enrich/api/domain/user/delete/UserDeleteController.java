package com.thanhnd101.enrich.api.domain.user.delete;

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
@RequestMapping("/api/users")
public class UserDeleteController {

  private final UserDeleteService userDeleteService;

  @DeleteMapping
  @PreAuthorize("hasRole('client_admin')")
  public ResponseEntity<UserDeleteResponse> delete(
      @RequestBody UserDeleteRequest userDeleteRequest) {
    return ResponseEntity.ok(userDeleteService.execute(userDeleteRequest));
  }
}
