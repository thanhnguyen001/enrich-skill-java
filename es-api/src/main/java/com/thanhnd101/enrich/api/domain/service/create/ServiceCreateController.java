package com.thanhnd101.enrich.api.domain.service.create;

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
@RequestMapping("/api/services")
public class ServiceCreateController {

  private final ServiceCreateService serviceCreateService;

  @PostMapping
  public ResponseEntity<ServiceCreateResponse> create(
      @RequestBody ServiceCreateRequest serviceCreateRequest) {
    return ResponseEntity.ok(serviceCreateService.execute(serviceCreateRequest));
  }

}