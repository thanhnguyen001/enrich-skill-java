package com.thanhnd101.enrich.api.domain.userService.approval;

import com.thanhnd101.enrich.core.entity.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User update DTO.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceUpdateRequest {

  private Long serviceid;
  private String userid;
  private int status;

  public UserService convertToUserService() {
    return UserService.builder()
        .serviceid(this.serviceid)
        .userid(this.userid)
        .status(this.status)
        .build();
  }
}
