package com.thanhnd101.enrich.api.domain.user.update;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserUpdateService implements CreateService<UserUpdateRequest, UserUpdateResponse> {

  private final UserRepository userRepository;

  @Override
  public UserUpdateResponse execute(UserUpdateRequest userUpdateRequest) {
    User user = userUpdateRequest.convertToUser();
    UserUpdateResponse userResponse = UserUpdateResponse.of(user);
    Long id = userRepository.update(user);
    return userResponse;
  }
}

