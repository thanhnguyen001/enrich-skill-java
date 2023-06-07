package com.thanhnd101.enrich.core.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Some javadoc.
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
  private Timestamp createdAat;
  private String createdBy;
  private Timestamp updatedAt;
  private String updatedBy;
  private Timestamp deletedAt;
  private String deletedBy;
}

