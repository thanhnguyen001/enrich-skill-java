package com.thanhnd101.enrich.api.domain.userService.search;

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
public class UserServiceSearchPageResponse {

  private List<UserServiceSearchResponse> listService;
  private int pageSize;
  private int currentPage;
  private int totalPage;

  /**
   * UserServiceSearchPageResponse.
   */
  public static UserServiceSearchPageResponse of(List<UserServiceSearchResponse> list, int currentPageRes,
      int pageSizeRes, int totalPage) {
    totalPage = totalPage <= 0 ? 1 : totalPage;
    return UserServiceSearchPageResponse.builder()
        .listService(list)
        .currentPage(currentPageRes)
        .pageSize(pageSizeRes)
        .totalPage(totalPage)
        .build();
  }
}
