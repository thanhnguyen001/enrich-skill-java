package com.thanhnd101.enrich.api.domain.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class ServiceUserController {

  private final ServiceUserService serviceUserService;

  @GetMapping
  public ResponseEntity<List<ServiceUserResponse>> getUsers() {
    return ResponseEntity.ok(serviceUserService.execute(ServiceUserRequest.builder().build()));
  }

}
