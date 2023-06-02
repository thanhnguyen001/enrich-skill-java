package com.thanhnd101.enrich.springboot.myapp.rest;

import com.thanhnd101.enrich.springboot.myapp.mapper.UserMapper;
import com.thanhnd101.enrich.springboot.myapp.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user mapper.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

  private final UserMapper userMapper;

  /**
   * get all users.
   *
   * @return list users.
   */
  @GetMapping("/users")
  public List<User> getUsers() {
    return userMapper.findAll();
  }
}
