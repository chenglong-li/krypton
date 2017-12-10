package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.Coin;
import com.assignment.cryptocurrency.model.entity.Exchange;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.model.entity.Wallet;
import com.assignment.cryptocurrency.repository.CoinRepository;
import com.assignment.cryptocurrency.repository.ExchangeRepository;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.repository.WalletRepository;
import com.assignment.cryptocurrency.service.ExchangeService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExchangeServiceImpl implements ExchangeService {

  private final ExchangeRepository exchangeRepository;

  private final UserRepository userRepository;

  private final WalletRepository walletRepository;

  private final CoinRepository coinRepository;

  public ExchangeServiceImpl(ExchangeRepository exchangeRepository,
      UserRepository userRepository,
      WalletRepository walletRepository,
      CoinRepository coinRepository) {
    this.exchangeRepository = exchangeRepository;
    this.userRepository = userRepository;
    this.walletRepository = walletRepository;
    this.coinRepository = coinRepository;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Exchange exchange(Exchange exchange) {

    User user = new User();
    user.setId(exchange.getUserId());
    List<Wallet> walletList = walletRepository.findByUserId(exchange.getUserId());
    BigDecimal originPrice = exchange.getOriginPrice();
    BigDecimal originAmount = exchange.getOriginAmount();
    BigDecimal destPrice = exchange.getDestPrice();
    BigDecimal destAmount = originPrice.multiply(originAmount)
        .divide(destPrice, 0, RoundingMode.HALF_UP);
    exchange.setDestAmount(destAmount);

    List<Coin> coinList = coinRepository.findAll();
    Map<Integer, String> coinMap = coinList.stream()
        .collect(Collectors.toMap(Coin::getId, Coin::getName));

    List<Wallet> saveWalletList = new ArrayList<>();
    walletList.forEach(w -> {
      String coinName = coinMap.get(w.getCoinId());
      if (exchange.getOriginType().name().equals(coinName)) {
        w.setAmount(w.getAmount().add(exchange.getOriginAmount().negate()));
        saveWalletList.add(w);
      }
      if (exchange.getDestType().name().equals(coinName)) {
        w.setAmount(w.getAmount().add(exchange.getDestAmount()));
        saveWalletList.add(w);
      }
    });
    walletRepository.save(saveWalletList);
    return exchangeRepository.save(exchange);
  }
}
