package com.thanhnd101.enrich.springboot.myapp.rest;

import com.thanhnd101.enrich.springboot.mapper.UserMapper;
import com.thanhnd101.enrich.springboot.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user mapper.
 *
 * @author thanhnd101
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FunRestController {

  private final UserMapper userMapper;

  /**
   * get all users.
   * @return list users.
   */
  @GetMapping("/users")
  public int getUsers() {
    List<User> listUser = userMapper.findAll();

    return listUser.size();
  }
}
