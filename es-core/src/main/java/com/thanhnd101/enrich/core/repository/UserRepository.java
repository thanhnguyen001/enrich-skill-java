package com.thanhnd101.enrich.core.repository;

import com.thanhnd101.enrich.core.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * User model.
 */
@Mapper
public interface UserRepository {

  List<User> findAll();
}
