package com.assignment.cryptocurrency.controller;


import com.assignment.cryptocurrency.general.Validation;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.UserService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Users", produces = MediaType.APPLICATION_JSON_VALUE)
public class VerificationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final Validation validation;
  private final UserService userService;

  public VerificationController(Validation validation,
      UserService userService) {
    this.validation = validation;
    this.userService = userService;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void update(@PathVariable Integer id, @RequestParam String status)
      throws NotFoundException {
    validation.verifyByUserId(id);
    User user = userService.findOne(id);
    user.setStatus(status.toUpperCase());
    userService.createOrUpdate(user);
  }

}
