package com.thanhnd101.enrich.api.domain.userService.create;

import com.thanhnd101.enrich.core.entity.UserService;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * service post.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceCreateRequest {

  private String userid;
  private Long serviceid;

  /**
   * convertToService.
   */
  public UserService convertToUserService() {
    OffsetDateTime createdAt = OffsetDateTime.now();
    OffsetDateTime updatedAt = OffsetDateTime.now();

    return UserService.builder().userid(this.userid).serviceid(this.serviceid).createdBy("system").createdAt(createdAt)
        .updatedBy("system").updatedAt(updatedAt).build();
  }
}
