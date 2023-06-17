package com.thanhnd101.enrich.api.domain.user.create;

import com.thanhnd101.enrich.api.service.CreateService;
import com.thanhnd101.enrich.core.entity.User;
import com.thanhnd101.enrich.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * user api service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserCreateService implements CreateService<UserCreateDto, UserCreateResponse> {

  private final UserRepository userRepository;

  @Override
  public UserCreateResponse execute(UserCreateDto userCreateDto) {
    User user = userCreateDto.convertToUser();
    UserCreateResponse userResponse = UserCreateResponse.of(user);
    Long id = userRepository.create(user);
    return userResponse;
  }
}
