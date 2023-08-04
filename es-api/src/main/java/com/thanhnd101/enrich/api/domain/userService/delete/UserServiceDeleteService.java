package com.thanhnd101.enrich.api.domain.userService.delete;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.repository.UserServiceRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserServiceDeleteService implements
    CreateService<UserServiceDeleteRequest, UserServiceDeleteResponse> {

  private final UserServiceRepository userServiceRepository;

  @Override
  public UserServiceDeleteResponse execute(
      UserServiceDeleteRequest userServiceDeleteRequest) {

    Long i = switch (userServiceDeleteRequest.getDeleteBy()) {
      case BY_USER -> userServiceRepository.deleteByUser(userServiceDeleteRequest.getUserIds());
      case BY_SERVICE ->
          userServiceRepository.deleteByService(userServiceDeleteRequest.getServiceIds());
      case BY_KEYS -> userServiceRepository.delete(userServiceDeleteRequest.getUserid(),
          userServiceDeleteRequest.getServiceid());
    };

    return UserServiceDeleteResponse.builder().successful(i > 0).build();
  }
}
