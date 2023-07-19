package com.thanhnd101.enrich.api.domain.user.search;

import com.thanhnd101.enrich.core.entity.User;
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
public class UserSearchRequest {

  private String username;
  private String email;
  private String address;
  private String id;
  private int pageNumber;
  private int pageSize;
  private int totalPage;

  /**
   * convertToUser.
   */
  public User convertToUser() {
    return User.builder()
        .id(this.id)
        .username(this.username)
        .email(this.email)
        .address(this.address)
        .build();
  }
}
