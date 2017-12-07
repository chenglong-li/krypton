package com.assignment.cryptocurrency.controller;

import com.assignment.cryptocurrency.model.domain.UserDomain;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.RegisterService;
import com.assignment.cryptocurrency.service.UserService;
import com.assignment.cryptocurrency.util.enums.UserStatus;
import javassist.NotFoundException;
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
@RequestMapping(value = "/api/Users", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

  private final UserService userService;
  private final RegisterService registerService;

  @Autowired
  public RegisterController(UserService userService, RegisterService registerService) {
    this.userService = userService;
    this.registerService = registerService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public User register(@Validated @RequestBody UserDomain userDomain,
      @RequestParam(required = false) String inviteCode, BindingResult result)
      throws NotFoundException {
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
    registerService.register(user, inviteCode);
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
