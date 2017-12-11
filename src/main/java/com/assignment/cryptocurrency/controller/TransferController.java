package com.assignment.cryptocurrency.controller;

import com.assignment.cryptocurrency.model.domain.TransferDomain;
import com.assignment.cryptocurrency.model.entity.Transfer;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.TransferService;
import com.assignment.cryptocurrency.service.UserService;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Users", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransferController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

  private final TransferService transferService;
  private final UserService userService;

  public TransferController(TransferService transferService,
      UserService userService) {
    this.transferService = transferService;
    this.userService = userService;
  }


  @RequestMapping(value = {"/{id}/Transfers"}, method = RequestMethod.POST)
  public void transfer(@Validated @RequestBody TransferDomain transferDomain,
      @PathVariable Integer id,
      BindingResult result) {

    if (result.hasErrors()) {
      throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
    }

    Transfer transfer = new Transfer();
    transfer.setCreateTime(new Date());
    transfer.setCryptonAmount(transferDomain.getCryptonAmount());
    transfer.setOriginUserId(id);
    transfer.setCryptonPrice(transferDomain.getCryptonPrice());
    transfer.setCryptonType(transferDomain.getCryptonType().toUpperCase());
    User destUser = userService.findByUsername(transferDomain.getDestUsername());
    transfer.setDestUserId(destUser.getId());

    transferService.transfer(transfer);


  }
}
