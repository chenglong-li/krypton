package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.general.VoucherServiceFactory;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.model.entity.Voucher;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.service.RegisterService;
import com.assignment.cryptocurrency.service.VoucherService;
import com.assignment.cryptocurrency.util.enums.VoucherType;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 06/12/2017.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);

  private final VoucherServiceFactory voucherServiceFactory;

  private final UserRepository userRepository;

  @Autowired
  public RegisterServiceImpl(VoucherServiceFactory voucherServiceFactory,
      UserRepository userRepository) {
    this.voucherServiceFactory = voucherServiceFactory;
    this.userRepository = userRepository;
  }

  @Override
  public User register(User user, String inviteCode) throws NotFoundException {
    VoucherService voucherService = voucherServiceFactory.getInstance(VoucherType.INVITE);
    Voucher voucher = voucherService.verify(inviteCode);
    if (voucher!=null) {
      //TODO update balance for inviter
      LOGGER.info("rewarded {}", voucher.getUserId());
    }
    User existedUser = userRepository.findByUsernameEquals(user.getUsername());
    if (existedUser != null) {
      throw new IllegalArgumentException("The user username is already existed!");
    }
    return userRepository.save(user);
  }
}
