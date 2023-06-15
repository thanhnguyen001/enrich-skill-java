package com.thanhnd101.enrich.api.domain.user.create;

import com.thanhnd101.enrich.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * user post.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

  private String username;
  private String password;
  private String email;
  private String address;

  public User convertToUser() {
    User user = User.builder().username(this.username).email(this.email).password(this.password)
        .address(this.address).build();

    return user;
  }
}
