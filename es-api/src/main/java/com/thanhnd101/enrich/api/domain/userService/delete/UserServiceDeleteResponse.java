package com.thanhnd101.enrich.api.domain.userService.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User api response.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceDeleteResponse {
  private Boolean successful;
}

