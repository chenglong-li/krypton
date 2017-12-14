package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.model.entity.Voucher;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.repository.VoucherRepository;
import com.assignment.cryptocurrency.service.InviteService;
import com.assignment.cryptocurrency.util.EmailUtil;
import com.assignment.cryptocurrency.util.enums.VoucherStatus;
import com.assignment.cryptocurrency.util.enums.VoucherType;
import java.util.Random;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 08/12/2017.
 */
@Service
public class InviteServiceImpl implements InviteService {

  private final VoucherRepository voucherRepository;

  private final UserRepository userRepository;

  @Autowired
  public InviteServiceImpl(VoucherRepository voucherRepository, UserRepository userRepository) {
    this.voucherRepository = voucherRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void invite(Integer userId, String email) throws NotFoundException {

    User user = userRepository.findOne(userId);
    if (user == null) {
      throw new NotFoundException("The user does not exist");
    }
    String name = user.getFirstName();

    Voucher voucher = new Voucher();
    voucher.setUserId(userId);
    voucher.setType(VoucherType.INVITE.name());

    Example<Voucher> example = Example.of(voucher);
    Voucher existedVoucher = voucherRepository.findOne(example);
    String inviteCode;
    if (existedVoucher == null) {
      voucher.setCode(userId + (new Random().nextInt(100)+""));
      voucher.setLimits(-1);
      voucher.setStatus(VoucherStatus.INVALID.name());
      voucherRepository.save(voucher);
      inviteCode = voucher.getCode();
    }else {
      inviteCode = existedVoucher.getCode();
    }

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("longestar@sina.com");
    message.setTo(email);
    message.setSubject("Join Krypton!");
    String msg=name + " wants to invite you to join Krypton. The invite code is " + inviteCode;
    msg+="\nDid you know that you will get 20 bitcoins for free as soon as you join?";
    msg+="\nJoin today and all your wildest dreams will come true!";
    message.setText(msg);

    EmailUtil.sendSimpleMail(message);
  }
}
