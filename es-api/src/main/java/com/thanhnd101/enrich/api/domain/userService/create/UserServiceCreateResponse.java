package com.thanhnd101.enrich.api.domain.userService.create;

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
public class UserServiceCreateResponse {

  private Long serviceid;
  private String userid;
  private int status;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime createdAt;

  private String createdBy;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime updatedAt;

  private String updatedBy;

  /**
   * user-service api response.
   */
  public static UserServiceCreateResponse of(UserService userDervice) {
    return UserServiceCreateResponse.builder()
        .userid(userDervice.getUserid())
        .serviceid(userDervice.getServiceid())
        .status(userDervice.getStatus())
        .createdAt(OffsetDateTime.now())
        .createdBy("system")
        .updatedAt(OffsetDateTime.now())
        .updatedBy("system")
        .build();
  }
}
