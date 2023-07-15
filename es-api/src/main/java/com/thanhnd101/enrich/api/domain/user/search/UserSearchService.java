package com.thanhnd101.enrich.api.domain.user.search;

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
public class UserSearchService implements
    SearchPagingService<UserSearchRequest, UserSearchPageResponse> {

  private final UserRepository userRepository;

  @Override
  public UserSearchPageResponse execute(UserSearchRequest userSearchRequest) {
    int pageNumber = userSearchRequest.getPageNumber();
    int pageSize = userSearchRequest.getPageSize();
    RowBounds rowBounds = new RowBounds(pageNumber * pageSize, pageSize);
    User userSearchParams = userSearchRequest.convertToUser();
    List<User> listUser = userRepository.findAll(userSearchParams.getId(),
        userSearchParams.getUsername(), userSearchParams.getEmail(), userSearchParams.getAddress(),
        rowBounds);
    List<UserSearchResponse> listUserRes = listUser.stream().map(UserSearchResponse::of).toList();
    int count = userRepository.count(userSearchRequest.convertToUser());
    int totalPage = (int) Math.ceil(count / userSearchRequest.getPageSize());
    return UserSearchPageResponse.of(listUserRes, userSearchRequest.getPageNumber(),
        userSearchRequest.getPageSize(), totalPage);
  }
}
