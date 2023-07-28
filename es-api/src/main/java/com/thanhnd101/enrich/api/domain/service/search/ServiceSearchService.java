package com.thanhnd101.enrich.api.domain.service.search;

import com.thanhnd101.enrich.api.service.SearchPagingService;
import com.thanhnd101.enrich.core.entity.Service;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.ServiceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceSearchService implements
    SearchPagingService<ServiceSearchRequest, ServiceSearchPageResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public ServiceSearchPageResponse execute(ServiceSearchRequest serviceSearchRequest) {
    int pageNumber = serviceSearchRequest.getPageNumber();
    int pageSize = serviceSearchRequest.getPageSize();
    RowBounds rowBounds = new RowBounds(pageNumber * pageSize, pageSize);
    Service serviceSearchParams = serviceSearchRequest.convertToUser();
    List<Service> listService = serviceRepository.findAll(serviceSearchParams.getId(),
        serviceSearchParams.getName(), serviceSearchParams.getStatus(),
        rowBounds);
    List<ServiceSearchResponse> listUserRes = listService.stream().map(
        ServiceSearchResponse::of).toList();
    int count = serviceRepository.count(serviceSearchRequest.convertToUser());
    int totalPage = count / serviceSearchRequest.getPageSize();
    return ServiceSearchPageResponse.of(listUserRes, serviceSearchRequest.getPageNumber(),
        serviceSearchRequest.getPageSize(), totalPage);
  }
}
