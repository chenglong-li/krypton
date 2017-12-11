package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.Coin;
import com.assignment.cryptocurrency.model.entity.Transfer;
import com.assignment.cryptocurrency.model.entity.Wallet;
import com.assignment.cryptocurrency.repository.CoinRepository;
import com.assignment.cryptocurrency.repository.TransferRepository;
import com.assignment.cryptocurrency.repository.WalletRepository;
import com.assignment.cryptocurrency.service.TransferService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

  private final TransferRepository transferRepository;
  private final WalletRepository walletRepository;
  private final CoinRepository coinRepository;

  @Autowired
  public TransferServiceImpl(
      TransferRepository transferRepository,
      WalletRepository walletRepository,
      CoinRepository coinRepository) {
    this.transferRepository = transferRepository;
    this.walletRepository = walletRepository;
    this.coinRepository = coinRepository;
  }

  @Override
  public void transfer(Transfer transfer) {
    List<Coin> coinList = coinRepository.findAll();
    coinList.forEach(c-> c.setName(c.getName().toUpperCase()));
    Map<String, Integer> coinMap = coinList.stream()
        .collect(Collectors.toMap(Coin::getName, Coin::getId));

    Wallet originWallet = walletRepository.findByUserIdAndCoinId(
        transfer.getOriginUserId(),
        coinMap.get(transfer.getCryptonType()));
    if (originWallet.getAmount().compareTo(transfer.getCryptonAmount()) < 0) {
      throw new IllegalArgumentException("The user doesn't have enough " + transfer.getCryptonType());
    }
    BigDecimal transferAmount = transfer.getCryptonAmount().negate();
    originWallet.setAmount(originWallet.getAmount().add(transferAmount));
    Wallet destWallet = walletRepository.findByUserIdAndCoinId(
        transfer.getDestUserId(),
        coinMap.get(transfer.getCryptonType()));
    destWallet.setAmount(destWallet.getAmount().add(transfer.getCryptonAmount()));
    List<Wallet> walletList = new ArrayList<>();
    walletList.add(originWallet);
    walletList.add(originWallet);
    walletRepository.save(walletList);
    transferRepository.save(transfer);
  }
}
