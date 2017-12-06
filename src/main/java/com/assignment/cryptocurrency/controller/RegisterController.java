package com.assignment.cryptocurrency.controller;

import com.assignment.cryptocurrency.model.domain.UserDomain;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.UserService;
import com.assignment.cryptocurrency.util.enums.UserStatus;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jackie on 05/12/2017.
 */
@RestController
@RequestMapping(value = "/api/sUsers", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.POST)
  public User register(@Validated @RequestBody UserDomain userDomain, BindingResult result) {
    if (result.hasErrors()) {
      throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
    }
    User user = new User();
    user.setUsername(userDomain.getUsername());
    user.setPassword(userDomain.getPassword());
    user.setEmail(userDomain.getEmail());
    user.setFirstName(userDomain.getFirstName());
    user.setLastName(userDomain.getLastName());
    user.setMobile(userDomain.getMobile());
    user.setStatus(UserStatus.NEW.name());
    userService.create(user);
    LOGGER.info("user created");
    return user;
  }

  @RequestMapping(method = RequestMethod.GET)
  public Page<User> listAll(
      User user,
      @RequestParam(name = "page", defaultValue = "0") Integer page,
      @RequestParam(name = "size", defaultValue = "10") Integer size) {

    return userService.findAll(
        user, new PageRequest(page, size, new Sort(Direction.ASC, "username")));
  }

}
