package com.thanhnd101.enrich.core.repository;

import com.thanhnd101.enrich.core.entity.User;
import java.util.List;

/**
 * User model.
 */
public interface UserRepository {

  List<User> findAll();
}
