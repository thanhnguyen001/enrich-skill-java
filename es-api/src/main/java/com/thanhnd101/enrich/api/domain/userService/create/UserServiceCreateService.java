package com.thanhnd101.enrich.api.domain.userService.create;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.UserService;
import com.thanhnd101.enrich.core.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserServiceCreateService implements
    CreateService<UserServiceCreateRequest, UserServiceCreateResponse> {

  private final UserServiceRepository userServiceRepository;

  @Override
  public UserServiceCreateResponse execute(UserServiceCreateRequest serviceCreateRequest) {
    UserService userService = serviceCreateRequest.convertToUserService();
    UserServiceCreateResponse serviceCreateResponse = UserServiceCreateResponse.of(userService);
    userServiceRepository.create(userService);

    return serviceCreateResponse;
  }
}
