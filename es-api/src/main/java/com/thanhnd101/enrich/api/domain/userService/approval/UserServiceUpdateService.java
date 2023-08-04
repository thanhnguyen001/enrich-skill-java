package com.thanhnd101.enrich.api.domain.userService.approval;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.UserService;
import com.thanhnd101.enrich.core.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserServiceUpdateService implements CreateService<UserServiceUpdateRequest, UserServiceUpdateResponse> {

  private final UserServiceRepository userServiceRepository;

  @Override
  public UserServiceUpdateResponse execute(UserServiceUpdateRequest userServiceUpdateRequest) {
    UserService userService = userServiceUpdateRequest.convertToUserService();
    UserServiceUpdateResponse userServiceUpdateResponse = UserServiceUpdateResponse.of(userService);
    userServiceRepository.update(userService);

    return userServiceUpdateResponse;
  }
}

