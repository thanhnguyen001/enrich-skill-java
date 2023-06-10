package com.thanhnd101.enrich.service.domain.user;

import com.thanhnd101.enrich.service.service.SearchService;
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
public class ServiceUserService implements SearchService<ServiceUserRequest, ServiceUserResponse> {

//  @Autowired
  private final UserRepository userRepository;

  @Override
  public List<ServiceUserResponse> execute(ServiceUserRequest serviceUserRequest) {
    List<User> listUser = userRepository.findAll();
    return listUser.stream().map(ServiceUserResponse::of).toList();
  }
}
