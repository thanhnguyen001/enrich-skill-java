package com.thanhnd101.enrich.api.domain.service.update;

import com.thanhnd101.enrich.core.entity.Service;
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
public class ServiceUpdateRequest {

  private Long id;
  private String name;
  private int status;

  public Service convertToService() {
    return Service.builder()
        .id(this.id)
        .name(this.name)
        .status(this.status)
        .build();
  }
}
