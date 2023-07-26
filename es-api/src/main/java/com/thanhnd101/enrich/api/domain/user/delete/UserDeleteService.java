package com.thanhnd101.enrich.api.domain.user.delete;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserDeleteService implements CreateService<UserDeleteRequest, UserDeleteResponse> {

  private final UserRepository userRepository;

  @Override
  public UserDeleteResponse execute(UserDeleteRequest userDeleteRequest) {
    Long i = userRepository.delete(userDeleteRequest.getIds());

    return UserDeleteResponse.builder().successful(i > 0).build();
  }
}
