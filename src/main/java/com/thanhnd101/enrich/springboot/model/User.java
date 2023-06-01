package com.thanhnd101.enrich.springboot.model;

import lombok.Data;

/**
 * Some javadoc.
 */

@SuppressWarnings("checkstyle:ModifierOrder")
public @Data class User {

  private String id;
  private String username;
  private String password;
  private String birthday;
  private String email;
  private String address;

  @Override
  public String toString() {
    return this.id;
  }
}
