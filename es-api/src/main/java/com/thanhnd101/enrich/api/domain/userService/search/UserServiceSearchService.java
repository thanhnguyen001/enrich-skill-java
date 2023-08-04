package com.thanhnd101.enrich.api.domain.userService.search;

import com.thanhnd101.enrich.api.service.SearchPagingService;
import com.thanhnd101.enrich.core.entity.UserService;
import com.thanhnd101.enrich.core.repository.UserServiceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserServiceSearchService implements
    SearchPagingService<UserServiceSearchRequest, UserServiceSearchPageResponse> {

  private final UserServiceRepository userServiceRepository;

  @Override
  public UserServiceSearchPageResponse execute(UserServiceSearchRequest userServiceSearchRequest) {
    int pageNumber = userServiceSearchRequest.getPageNumber();
    int pageSize = userServiceSearchRequest.getPageSize();
    RowBounds rowBounds = new RowBounds(pageNumber * pageSize, pageSize);

    UserService serviceSearchParams = userServiceSearchRequest.convertToUserService();
    List<UserService> listUserService = userServiceRepository.findAll(serviceSearchParams.getUserid(),
        serviceSearchParams.getServiceid(), serviceSearchParams.getStatus(),
        rowBounds);
    List<UserServiceSearchResponse> listUserServiceRes = listUserService.stream().map(
        UserServiceSearchResponse::of).toList();

    int count = userServiceRepository.count(userServiceSearchRequest.convertToUserService());
    int totalPage = count / userServiceSearchRequest.getPageSize();

    return UserServiceSearchPageResponse.of(listUserServiceRes, userServiceSearchRequest.getPageNumber(),
        userServiceSearchRequest.getPageSize(), totalPage);
  }
}
