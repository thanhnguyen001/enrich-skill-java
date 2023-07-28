package com.thanhnd101.enrich.api.domain.service.search;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class ServiceSearchController {

  private final ServiceSearchService serviceSearchService;

  /**
   * Api Search User.
   */
  @GetMapping()
  @PreAuthorize("hasRole('Admin')")
  public ResponseEntity<ServiceSearchPageResponse> getUsers(
      @RequestParam(defaultValue = "") Long id,
      @RequestParam(defaultValue = "") String name,
      @RequestParam(defaultValue = "") int status,
      @RequestParam(defaultValue = "3") int pageSize,
      @RequestParam(defaultValue = "0") int pageNumber
  ) {
    ServiceSearchRequest serviceSearchRequest = new ServiceSearchRequest();
    // Set null to run condition <where> mybatis SQL in xml file
    serviceSearchRequest.setId(null);
    serviceSearchRequest.setName(null);
    serviceSearchRequest.setPageSize(pageSize);
    serviceSearchRequest.setPageNumber(pageNumber);

    if (!name.isEmpty()) {
      serviceSearchRequest.setName("%" + name + "%");
    }
    if (id > 0) {
      serviceSearchRequest.setId(id);
    }
    if (status > 0) {
      serviceSearchRequest.setStatus(status);
    }
    return ResponseEntity.ok(serviceSearchService.execute(serviceSearchRequest));
  }
}
