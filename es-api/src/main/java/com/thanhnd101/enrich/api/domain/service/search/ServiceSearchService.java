package com.thanhnd101.enrich.api.domain.service.search;

import com.thanhnd101.enrich.api.service.SearchPagingService;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.UserRepository;
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

  private final UserRepository userRepository;

  @Override
  public ServiceSearchPageResponse execute(ServiceSearchRequest serviceSearchRequest) {
    int pageNumber = serviceSearchRequest.getPageNumber();
    int pageSize = serviceSearchRequest.getPageSize();
    RowBounds rowBounds = new RowBounds(pageNumber * pageSize, pageSize);
    User userSearchParams = serviceSearchRequest.convertToUser();
    List<User> listUser = userRepository.findAll(userSearchParams.getId(),
        userSearchParams.getUsername(), userSearchParams.getEmail(), userSearchParams.getAddress(),
        rowBounds);
    List<ServiceSearchResponse> listUserRes = listUser.stream().map(
        ServiceSearchResponse::of).toList();
    int count = userRepository.count(serviceSearchRequest.convertToUser());
    int totalPage = count / serviceSearchRequest.getPageSize();
    return ServiceSearchPageResponse.of(listUserRes, serviceSearchRequest.getPageNumber(),
        serviceSearchRequest.getPageSize(), totalPage);
  }
}
