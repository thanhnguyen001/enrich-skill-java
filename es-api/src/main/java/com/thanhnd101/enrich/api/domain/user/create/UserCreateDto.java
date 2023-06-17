package com.thanhnd101.enrich.api.domain.user.create;

import com.thanhnd101.enrich.core.entity.User;
import java.time.LocalDate;
import java.time.OffsetDateTime;
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
    String id = this.username;
    OffsetDateTime createdAt = OffsetDateTime.now();
    OffsetDateTime updatedAt = OffsetDateTime.now();

    User user = User.builder().id(id).username(this.username).email(this.email).password(this.password)
        .address(this.address).birthday(LocalDate.now()).createdBy("system").createdAt(createdAt).updatedBy("system").updatedAt(updatedAt).build();

    return user;
  }
}
