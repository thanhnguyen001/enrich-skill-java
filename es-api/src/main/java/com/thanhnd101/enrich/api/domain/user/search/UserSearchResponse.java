package com.thanhnd101.enrich.api.domain.user.search;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thanhnd101.enrich.core.entity.User;
import java.time.LocalDate;
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
public class UserSearchResponse {

  private String id;
  private String username;
  private String password;
  private LocalDate birthday;
  private String email;
  private String address;

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

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime deletedAt;

  private String deletedBy;

  /**
   * user api response.
   */
  public static UserSearchResponse of(User user) {
    return UserSearchResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .password(user.getPassword())
        .address(user.getAddress())
        .birthday(user.getBirthday())
        .email(user.getEmail())
        .createdBy(user.getCreatedBy())
        .updatedAt(user.getUpdatedAt())
        .updatedBy(user.getUpdatedBy())
        .deletedAt(user.getDeletedAt())
        .deletedBy(user.getDeletedBy())
        .build();
  }
}
