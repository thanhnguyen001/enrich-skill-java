package com.thanhnd101.enrich.api.service;

import java.util.List;

/**
 * search service.
 *
 * @param <S> request
 * @param <T> response
 */
public interface SearchPagingService<S, T> {

  T execute(S request);
}
