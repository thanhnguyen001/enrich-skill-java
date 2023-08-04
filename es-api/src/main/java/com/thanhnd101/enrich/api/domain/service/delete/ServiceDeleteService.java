package com.thanhnd101.enrich.api.domain.service.delete;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceDeleteService implements CreateService<ServiceDeleteRequest, ServiceDeleteResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public ServiceDeleteResponse execute(
      ServiceDeleteRequest serviceDeleteRequest) {
    Long i = serviceRepository.delete(serviceDeleteRequest.getIds());

    return ServiceDeleteResponse.builder().successful(i > 0).build();
  }
}
