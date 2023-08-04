package com.thanhnd101.enrich.api.domain.service.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thanhnd101.enrich.core.entity.Service;
import java.time.OffsetDateTime;
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
public class ServiceUpdateResponse {

  private Long id;
  private String name;
  private int status;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime updatedAt;

  private String updatedBy;

  /**
   * user api response.
   */
  public static ServiceUpdateResponse of(Service service) {
    return ServiceUpdateResponse.builder()
        .id(service.getId())
        .name(service.getName())
        .status(service.getStatus())
        .updatedAt(OffsetDateTime.now())
        .updatedBy("system")
        .build();
  }
}