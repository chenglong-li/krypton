package com.assignment.cryptocurrency.controller;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.LoginService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jackie on 05/12/2017.
 */
@RestController
@RequestMapping(value = "/api/Users", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @RequestMapping(value = "/Login", method = RequestMethod.GET)
  public User login(@RequestParam String username, @RequestParam String password)
      throws NotFoundException {
    return loginService.login(username, password);
  }

}
