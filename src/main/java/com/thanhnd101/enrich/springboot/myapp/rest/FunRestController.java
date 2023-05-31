package com.thanhnd101.enrich.springboot.myapp.rest;

import com.thanhnd101.enrich.springboot.myapp.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NguyenThanh
 */
@RestController
public class FunRestController {

  @GetMapping("/")
  public String sayHello() {

    return "Hello World";
  }
}
