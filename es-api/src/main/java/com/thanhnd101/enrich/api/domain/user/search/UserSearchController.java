package com.thanhnd101.enrich.api.domain.user.search;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
      @RequestParam(defaultValue = "1") int pageNumber
  ) {

    System.out.println("=================================================================================================================================");
    System.out.println(id);
    System.out.println(username);
    System.out.println(email);
    System.out.println(address);
    System.out.println("=================================================================================================================================");

    UserSearchRequest userSearchRequest = new UserSearchRequest();
    // Set null to run condition <where> mybatis SQL in xml file
    userSearchRequest.setId(null);
    userSearchRequest.setUsername(null);
    userSearchRequest.setEmail(null);
    userSearchRequest.setAddress(null);

    userSearchRequest.setPageSize(pageSize);
    userSearchRequest.setPageNumber((pageNumber - 1) * pageSize);
    userSearchRequest.setCurrentPage(pageNumber);
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
