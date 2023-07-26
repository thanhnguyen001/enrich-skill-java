package com.thanhnd101.enrich.api.domain.user.update;

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
 * User update DTO.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

  private String id;
  private String username;
  private String password;
  private String email;
  private String address;
  private LocalDate birthday;

  public User convertToUser() {
    return User.builder()
        .id(this.id)
        .username(this.username)
        .email(this.email)
        .password(this.password)
        .address(this.address)
        .birthday(this.birthday)
        .updatedBy("system")
        .updatedAt(OffsetDateTime.now())
        .build();
  }
}
