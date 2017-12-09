package com.assignment.cryptocurrency.controller;

import com.assignment.cryptocurrency.service.InviteService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jackie on 08/12/2017.
 */
@RestController
@RequestMapping(value = "/api/Users", produces = MediaType.APPLICATION_JSON_VALUE)
public class InviteController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final InviteService inviteService;

  @Autowired
  public InviteController(InviteService inviteService) {
    this.inviteService = inviteService;
  }

  @RequestMapping(value = "/{id}/Invite", method = RequestMethod.GET)
  public void invite(@PathVariable Integer id, @RequestParam String email)
      throws NotFoundException {
    inviteService.invite(id, email);
  }

}
