package com.thanhnd101.enrich.api.domain.user.search;

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
public class UserSearchPageResponse {
  private List<UserSearchResponse> listUser;
  private int pageSize;
  private int currentPage;
  private int totalPage;

  public static UserSearchPageResponse of(List<UserSearchResponse> list, int currentPageRes, int pageSizeRes, int totalPage) {
    return UserSearchPageResponse.builder()
        .listUser(list)
        .currentPage(currentPageRes)
        .pageSize(pageSizeRes)
        .totalPage(totalPage)
        .build();
  }
}
