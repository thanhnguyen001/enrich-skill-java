package com.thanhnd101.enrich.api.domain.userService.search;

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
public class UserServiceSearchResponse {

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
   * user api response.
   */
  public static UserServiceSearchResponse of(UserService userService) {
    return UserServiceSearchResponse.builder()
        .userid(userService.getUserid())
        .serviceid(userService.getServiceid())
        .status(userService.getStatus())
        .createdAt(userService.getCreatedAt())
        .createdBy(userService.getCreatedBy())
        .updatedAt(userService.getUpdatedAt())
        .updatedBy(userService.getUpdatedBy())
        .build();
  }
}
