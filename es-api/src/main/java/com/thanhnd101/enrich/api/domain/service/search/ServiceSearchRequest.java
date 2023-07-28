package com.thanhnd101.enrich.api.domain.service.search;

import com.thanhnd101.enrich.core.entity.Service;
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
public class ServiceSearchRequest {

  private String name;
  private int status;
  private Long id;
  private int pageSize;
  private int pageNumber;
  private int totalPage;

  /**
   * convertToUser.
   */
  public Service convertToUser() {
    return Service.builder()
        .id(this.id)
        .name(this.name)
        .status(this.status)
        .build();
  }
}
