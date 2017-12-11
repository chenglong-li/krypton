package com.assignment.cryptocurrency.controller;


import com.assignment.cryptocurrency.general.Validation;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.UserService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final Validation validation;
  private final UserService userService;

  public AdminController(Validation validation,
      UserService userService) {
    this.validation = validation;
    this.userService = userService;
  }

  @RequestMapping(value = "/{id}/Users/{userId}", method = RequestMethod.PUT)
  public void update(@PathVariable Integer id,
      @PathVariable Integer userId, @RequestParam String status)
      throws NotFoundException {
    validation.verifyByAdminId(id);
    validation.verifyByUserId(userId);
    User user = userService.findOne(userId);
    user.setStatus(status.toUpperCase());
    userService.createOrUpdate(user);
  }

  @RequestMapping(value = "/{id}/Users", method = RequestMethod.GET)
  public Page<User> list(@PathVariable Integer id, @RequestParam String status,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer size)
      throws NotFoundException {
    validation.verifyByAdminId(id);
    User user = new User();
    user.setStatus(status.toUpperCase());
    return userService.findAll(user, new PageRequest(page, size));
  }

}
