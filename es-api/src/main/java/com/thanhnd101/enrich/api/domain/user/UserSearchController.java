package com.thanhnd101.enrich.api.domain.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserSearchController {

  private final UserSearchService userSearchService;

  @GetMapping
  public ResponseEntity<List<UserSearchResponse>> getUsers() {
    return ResponseEntity.ok(userSearchService.execute(UserSearchRequest.builder().build()));
  }

}
