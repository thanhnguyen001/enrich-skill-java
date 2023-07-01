package com.thanhnd101.enrich.core.repository;

import com.thanhnd101.enrich.core.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * User model.
 */
@Mapper
public interface UserRepository {

  List<User> findAll(User user, RowBounds rowBounds);

  int count(User user);
  Long create(User user);

  Long update(User user);

  Long delete(@Param("ids") List<String> ids);
}
