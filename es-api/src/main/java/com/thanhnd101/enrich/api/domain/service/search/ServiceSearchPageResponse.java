package com.thanhnd101.enrich.api.domain.service.search;

import java.util.List;
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
public class ServiceSearchPageResponse {

  private List<ServiceSearchResponse> listUser;
  private int pageSize;
  private int currentPage;
  private int totalPage;

  /**
   * ServiceSearchPageResponse.
   */
  public static ServiceSearchPageResponse of(List<ServiceSearchResponse> list, int currentPageRes,
      int pageSizeRes, int totalPage) {
    totalPage = totalPage <= 0 ? 1 : totalPage;
    return ServiceSearchPageResponse.builder()
        .listUser(list)
        .currentPage(currentPageRes)
        .pageSize(pageSizeRes)
        .totalPage(totalPage)
        .build();
  }
}
