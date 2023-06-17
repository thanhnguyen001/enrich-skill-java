package com.thanhnd101.enrich.api.domain.user.delete;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @DeleteMapping("/{id}")
  public ResponseEntity<UserDeleteResponse> delete(@PathVariable String id) {
    return ResponseEntity.ok(userDeleteService.execute(id));
  }
}
