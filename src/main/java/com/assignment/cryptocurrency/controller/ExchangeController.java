package com.assignment.cryptocurrency.controller;


import com.assignment.cryptocurrency.model.domain.ExchangeDomain;
import com.assignment.cryptocurrency.model.entity.Exchange;
import com.assignment.cryptocurrency.service.ExchangeService;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Users/{id}/Exchange", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final ExchangeService exchangeService;

  @Autowired
  public ExchangeController(ExchangeService exchangeService) {
    this.exchangeService = exchangeService;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public void invite(@Validated @RequestBody ExchangeDomain exchangeDomain,
      @PathVariable("id") Integer id, BindingResult result) {

    if (result.hasErrors()) {
      throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
    }

    Exchange exchange = new Exchange();
    exchange.setOriginAmount(exchangeDomain.getOriginAmount());
    exchange.setOriginPrice(exchangeDomain.getOriginPrice());
    exchange.setOriginType(exchangeDomain.getOriginType());
    exchange.setDestPrice(exchangeDomain.getDestPrice());
    exchange.setDestType(exchangeDomain.getDestType());
    exchange.setUserId(id);
    exchange.setCreateTime(new Date());

    exchangeService.exchange(exchange);
  }

}
