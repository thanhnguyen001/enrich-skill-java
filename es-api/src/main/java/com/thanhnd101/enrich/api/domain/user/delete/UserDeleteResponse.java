package com.thanhnd101.enrich.api.domain.user.delete;

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
public class UserDeleteResponse {
  private Boolean successful;
}

