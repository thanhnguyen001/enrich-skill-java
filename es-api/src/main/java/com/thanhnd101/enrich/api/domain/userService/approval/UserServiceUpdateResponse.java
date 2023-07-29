package com.thanhnd101.enrich.api.domain.userService.approval;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thanhnd101.enrich.core.entity.UserService;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User api response.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceUpdateResponse {

  private Long serviceid;
  private String userid;
  private int status;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime updatedAt;

  private String updatedBy;

  /**
   * user api response.
   */
  public static UserServiceUpdateResponse of(UserService userService) {
    return UserServiceUpdateResponse.builder()
        .userid(userService.getUserid())
        .serviceid(userService.getServiceid())
        .status(userService.getStatus())
        .updatedAt(OffsetDateTime.now())
        .updatedBy("system")
        .build();
  }
}