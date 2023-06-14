package com.thanhnd101.enrich.api.service;

/**
 * create service.
 *
 * @param <S> request
 * @param <T> response
 */
public interface CreateService<S, T> {

  T execute(S request);
}
