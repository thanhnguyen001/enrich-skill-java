package com.thanhnd101.enrich.api.domain.service.delete;

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
@RequestMapping("/api/services")
public class ServiceDeleteController {

  private final ServiceDeleteService serviceDeleteService;

  @DeleteMapping
  @PreAuthorize("hasRole('Admin')")
  public ResponseEntity<ServiceDeleteResponse> delete(
      @RequestBody ServiceDeleteRequest serviceDeleteRequest) {
    return ResponseEntity.ok(serviceDeleteService.execute(serviceDeleteRequest));
  }
}
