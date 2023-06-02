package com.thanhnd101.enrich.springboot.myapp.model;

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
}
