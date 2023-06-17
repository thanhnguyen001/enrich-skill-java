package com.thanhnd101.enrich.api.domain.user.update;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * update user.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserUpdateController {

  private final UserUpdateService userUpdateService;
  @PutMapping("/{id}")
  public ResponseEntity<UserUpdateResponse> update(@PathVariable String id, @RequestBody UserUpdateRequest userUpdateRequest) {
    userUpdateRequest.setId(id);
    return ResponseEntity.ok(userUpdateService.execute(userUpdateRequest));
  }
}
