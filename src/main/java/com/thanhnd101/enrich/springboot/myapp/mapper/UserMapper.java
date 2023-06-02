package com.thanhnd101.enrich.springboot.myapp.mapper;

import com.thanhnd101.enrich.springboot.myapp.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper.xml check.
 *
 * @author thanhnd101
 */
@Mapper
public interface UserMapper {

  List<User> findAll();

//  User createUser();
//  @SuppressWarnings("checkstyle:EmptyLineSeparator")
//  User deleteUser();
}
