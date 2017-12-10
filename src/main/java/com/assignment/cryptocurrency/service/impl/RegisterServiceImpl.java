package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.general.VoucherServiceFactory;
import com.assignment.cryptocurrency.model.entity.Coin;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.model.entity.Voucher;
import com.assignment.cryptocurrency.model.entity.Wallet;
import com.assignment.cryptocurrency.repository.CoinRepository;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.repository.WalletRepository;
import com.assignment.cryptocurrency.service.RegisterService;
import com.assignment.cryptocurrency.service.VoucherService;
import com.assignment.cryptocurrency.util.enums.CoinType;
import com.assignment.cryptocurrency.util.enums.VoucherStatus;
import com.assignment.cryptocurrency.util.enums.VoucherType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jackie on 06/12/2017.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);

  private final VoucherServiceFactory voucherServiceFactory;

  private final CoinRepository coinRepository;

  private final UserRepository userRepository;

  private final WalletRepository walletRepository;

  @Autowired
  public RegisterServiceImpl(VoucherServiceFactory voucherServiceFactory,
      UserRepository userRepository, WalletRepository walletRepository,
      CoinRepository coinRepository) {
    this.voucherServiceFactory = voucherServiceFactory;
    this.userRepository = userRepository;
    this.walletRepository = walletRepository;
    this.coinRepository = coinRepository;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public User register(User user, String inviteCode) throws NotFoundException {

    LOGGER.info("reward the inviter...");
    List<Coin> coinList = coinRepository.findAll();
    Map<String, Integer> coinMap = coinList.stream()
        .collect(Collectors.toMap(Coin::getName, Coin::getId));

    Voucher voucher;
    VoucherService voucherService = voucherServiceFactory.getInstance(VoucherType.INVITE);
    if (inviteCode!=null && !inviteCode.isEmpty()) {
      voucher = voucherService.verify(inviteCode);
      if (voucher == null) {
        throw new NotFoundException("The invite code does not exist");
      }
      User inviter = userRepository.findOne(voucher.getUserId());
      Wallet bitcoinWallet = walletRepository.findByUserIdAndCoinId(
          inviter.getId(),
          coinMap.get(CoinType.Bitcoin.name()));
      bitcoinWallet.setAmount(bitcoinWallet.getAmount().add(new BigDecimal("1")));
      walletRepository.save(bitcoinWallet);
      LOGGER.info("rewarded {} 1 bitcoin", inviter.getFirstName());
    }
    User existedUser = userRepository.findByUsernameEquals(user.getUsername());
    if (existedUser != null) {
      throw new IllegalArgumentException("The user username is already existed!");
    }
    userRepository.save(user);

    LOGGER.info("create invite code...");
    voucher = new Voucher();
    voucher.setCode(user.getId() + (new Random().nextInt(100) + ""));
    voucher.setLimits(-1);
    voucher.setType(VoucherType.INVITE.name());
    voucher.setStatus(VoucherStatus.VALID.name());
    voucher.setUserId(user.getId());
    voucherService.save(voucher);

    LOGGER.info("create wallet for user...");
    List<Wallet> walletList = new ArrayList<>();
    coinList.forEach(coin -> {
      Wallet wallet = new Wallet();
      if (coin.getName().equals(CoinType.Bitcoin.name())) {
        wallet.setAmount(new BigDecimal("20"));
      } else {
        wallet.setAmount(new BigDecimal("0"));
      }
      wallet.setAddress(UUID.randomUUID().toString());
      wallet.setCoinId(coin.getId());
      wallet.setUserId(user.getId());
      walletList.add(wallet);
    });
    walletRepository.save(walletList);
    return user;
  }
}
