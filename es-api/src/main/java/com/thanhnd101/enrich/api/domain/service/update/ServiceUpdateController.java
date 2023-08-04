package com.thanhnd101.enrich.api.domain.service.update;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/services")
public class ServiceUpdateController {

  private final ServiceUpdateService serviceUpdateService;
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('Admin')")
  public ResponseEntity<ServiceUpdateResponse> update(@PathVariable Long id, @RequestBody ServiceUpdateRequest serviceUpdateRequest) {
    serviceUpdateRequest.setId(id);
    return ResponseEntity.ok(serviceUpdateService.execute(serviceUpdateRequest));
  }
}
