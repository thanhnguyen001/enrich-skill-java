package com.thanhnd101.enrich.api.domain.user.search;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserSearchController {

  private final UserSearchService userSearchService;

  @GetMapping()
  public ResponseEntity<UserSearchPageResponse> getUsers(
      @RequestParam(defaultValue = "") String id,
      @RequestParam(defaultValue = "") String username,
      @RequestParam(defaultValue = "") String email,
      @RequestParam(defaultValue = "") String address,
      @RequestParam(defaultValue = "3") int pageSize,
      @RequestParam(defaultValue = "0") int pageNumber
  ) {

    UserSearchRequest userSearchRequest = new UserSearchRequest();
    // Set null to run condition <where> mybatis SQL in xml file
    userSearchRequest.setId(null);
    userSearchRequest.setUsername(null);
    userSearchRequest.setEmail(null);
    userSearchRequest.setAddress(null);
    userSearchRequest.setPageSize(pageSize);
    userSearchRequest.setPageNumber(pageNumber);

    if (!id.isEmpty()) {
      userSearchRequest.setId(String.valueOf(id));
    }
    if (!username.isEmpty()) {
      userSearchRequest.setUsername(String.valueOf("%" + username + "%"));
    }
    if (!email.isEmpty()) {
      userSearchRequest.setEmail(String.valueOf("%" + email + "%"));
    }
    if (!address.isEmpty()) {
      userSearchRequest.setAddress(String.valueOf("%" + address + "%"));
    }

    return ResponseEntity.ok(userSearchService.execute(userSearchRequest));
  }
}
