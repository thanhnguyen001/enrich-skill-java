package com.thanhnd101.enrich.api.domain.user;

import com.thanhnd101.enrich.api.service.SearchService;
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
public class UserSearchService implements SearchService<UserSearchRequest, UserSearchResponse> {

//  @Autowired
  private final UserRepository userRepository;

  @Override
  public List<UserSearchResponse> execute(UserSearchRequest userSearchRequest) {
    List<User> listUser = userRepository.findAll();
    return listUser.stream().map(UserSearchResponse::of).toList();
  }
}
