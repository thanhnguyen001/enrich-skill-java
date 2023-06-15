package com.thanhnd101.enrich.api.domain.user.create;

import com.thanhnd101.enrich.api.domain.user.UserSearchResponse;
import com.thanhnd101.enrich.api.service.CreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/create")
public class UserCreateController {

  private final UserCreateService userCreateService;

  @PostMapping()
  public ResponseEntity<UserCreateResponse> create(@RequestBody String username,
      @RequestBody String password, @RequestBody String email, @RequestBody String address) {
    UserCreateDto userCreateDto = UserCreateDto.builder().username(username).password(password)
        .email(email).address(address).build();

    return ResponseEntity.ok(userCreateService.execute(userCreateDto));
  }
}
