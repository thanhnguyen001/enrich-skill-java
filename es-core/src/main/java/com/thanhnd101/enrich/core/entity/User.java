package com.thanhnd101.enrich.core.entity;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String id;
  private String username;
  private String password;
  private String birthday;
  private String email;
  private String address;
  private OffsetDateTime createdAat;
  private String createdBy;
  private OffsetDateTime updatedAt;
  private String updatedBy;
  private OffsetDateTime deletedAt;
  private String deletedBy;
}

