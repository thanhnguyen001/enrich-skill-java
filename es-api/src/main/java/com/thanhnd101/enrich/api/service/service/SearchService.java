package com.thanhnd101.enrich.service.service;

import java.util.List;

/**
 * search service.
 *
 * @param <S> request
 * @param <T> response
 */
public interface SearchService<S, T> {

  List<T> execute(S request);
}
