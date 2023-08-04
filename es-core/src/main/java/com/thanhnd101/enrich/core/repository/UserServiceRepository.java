package com.thanhnd101.enrich.core.repository;

import com.thanhnd101.enrich.core.entity.UserService;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * Service.
 */
@Mapper
public interface UserServiceRepository {

  List<UserService> findAll(@Param("userid") String userid,
      @Param("serviceid") Long serviceid,
      @Param("status") int status, RowBounds rowBounds);

  int count(UserService userService);

  Long create(UserService userService);

  Long update(UserService userService);

  Long delete(@Param("userid") String userid, @Param("serviceid") Long serviceid);

  Long deleteByUser(@Param("ids") List<String> ids);

  Long deleteByService(@Param("ids") List<Long> ids);
}
