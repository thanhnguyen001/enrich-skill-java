package com.thanhnd101.enrich.api.domain.userService.approval;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * update user.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-service")
public class UserServiceUpdateController {

  private final UserServiceUpdateService userServiceUpdateService;
  @PutMapping()
  @PreAuthorize("hasRole('Admin')")
  public ResponseEntity<UserServiceUpdateResponse> update(@RequestBody UserServiceUpdateRequest userServiceUpdateRequest) {
    return ResponseEntity.ok(userServiceUpdateService.execute(userServiceUpdateRequest));
  }
}
