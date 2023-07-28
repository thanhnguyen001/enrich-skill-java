package com.thanhnd101.enrich.api.domain.service.create;

import com.thanhnd101.enrich.core.entity.Service;
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
public class ServiceCreateRequest {

  private String name;

  /**
   * convertToService.
   */
  public Service convertToService() {
    OffsetDateTime createdAt = OffsetDateTime.now();
    OffsetDateTime updatedAt = OffsetDateTime.now();

    return Service.builder().name(this.name).createdBy("system").createdAt(createdAt)
        .updatedBy("system").updatedAt(updatedAt).build();
  }
}