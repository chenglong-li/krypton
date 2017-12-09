package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.general.AbstractVoucherService;
import com.assignment.cryptocurrency.model.entity.Voucher;
import com.assignment.cryptocurrency.repository.VoucherRepository;
import com.assignment.cryptocurrency.service.VoucherService;
import com.assignment.cryptocurrency.util.enums.VoucherType;
import javassist.NotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 06/12/2017.
 */
@Service
public class InviteCodeServiceImpl extends AbstractVoucherService implements VoucherService {

  public InviteCodeServiceImpl(
      VoucherRepository voucherRepository) {
    super(voucherRepository);
  }

  @Override
  public Voucher verify(String code) throws NotFoundException {
    Voucher voucher = valid(code);
    boolean isInviteCode = voucher.getType().equals(VoucherType.INVITE.name());
    if (!isInviteCode) {
      throw new ServiceException("The code is not invite code!");
    }
    return voucher;
  }

  @Override
  public Voucher save(Voucher voucher) {
    return voucherRepository.save(voucher);
  }
}
