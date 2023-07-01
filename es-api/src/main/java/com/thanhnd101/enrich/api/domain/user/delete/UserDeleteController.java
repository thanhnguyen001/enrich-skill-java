package com.thanhnd101.enrich.api.domain.user.delete;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<UserDeleteResponse> delete(@RequestBody UserDeleteRequest userDeleteRequest) {
    return ResponseEntity.ok(userDeleteService.execute(userDeleteRequest));
  }
}
