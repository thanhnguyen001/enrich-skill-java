package com.thanhnd101.enrich.api.domain.user.search;

import com.thanhnd101.enrich.api.service.SearchPagingService;
//import com.thanhnd101.enrich.api.service.SearchService;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements
    SearchPagingService<UserSearchRequest, UserSearchPageResponse> {

  //  @Autowired
  private final UserRepository userRepository;

  @Override
  public UserSearchPageResponse execute(UserSearchRequest userSearchRequest) {
    List<User> listUser = userRepository.findAll(userSearchRequest.convertToUser());
    List<UserSearchResponse> listUserRes = listUser.stream().map(UserSearchResponse::of).toList();
    int count = userRepository.count();
    int totalPage = (int)Math.ceil(count / userSearchRequest.getPageSize());
    return UserSearchPageResponse.of(listUserRes, userSearchRequest.getCurrentPage(),
        userSearchRequest.getPageSize(), totalPage);
  }
}
