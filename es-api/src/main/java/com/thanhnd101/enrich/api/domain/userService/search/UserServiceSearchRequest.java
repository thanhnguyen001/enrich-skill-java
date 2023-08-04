package com.thanhnd101.enrich.api.domain.userService.search;

import com.thanhnd101.enrich.core.entity.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * user request.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceSearchRequest {

  private String userid;
  private int status;
  private Long serviceid;
  private int pageSize;
  private int pageNumber;
  private int totalPage;

  /**
   * convertToUser.
   */
  public UserService convertToUserService() {
    return UserService.builder()
        .userid(this.userid)
        .serviceid(this.serviceid)
        .status(this.status)
        .build();
  }
}
