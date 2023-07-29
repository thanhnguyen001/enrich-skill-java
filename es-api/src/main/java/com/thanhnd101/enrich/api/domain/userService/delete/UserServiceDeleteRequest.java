package com.thanhnd101.enrich.api.domain.userService.delete;

import java.util.List;
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
public class UserServiceDeleteRequest {
  private List<Long> serviceIds;
  private List<String> userIds;
  private String userid;
  private Long serviceid;
  private UserServiceDeleteBy deleteBy;
}

