package com.thanhnd101.enrich.api.domain.service.update;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.Service;
import com.thanhnd101.enrich.core.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceUpdateService implements CreateService<ServiceUpdateRequest, ServiceUpdateResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public ServiceUpdateResponse execute(ServiceUpdateRequest serviceUpdateRequest) {
    Service service = serviceUpdateRequest.convertToService();
    ServiceUpdateResponse serviceUpdateResponse = ServiceUpdateResponse.of(service);
    serviceRepository.update(service);

    return serviceUpdateResponse;
  }
}

