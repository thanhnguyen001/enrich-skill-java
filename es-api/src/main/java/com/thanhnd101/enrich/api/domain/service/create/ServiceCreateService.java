package com.thanhnd101.enrich.api.domain.service.create;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.Service;
import com.thanhnd101.enrich.core.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceCreateService implements
    CreateService<ServiceCreateRequest, ServiceCreateResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public ServiceCreateResponse execute(ServiceCreateRequest serviceCreateRequest) {
      Service service = serviceCreateRequest.convertToService();
    ServiceCreateResponse serviceCreateResponse = ServiceCreateResponse.of(service);
    serviceRepository.create(service);

    return serviceCreateResponse;
  }
}
