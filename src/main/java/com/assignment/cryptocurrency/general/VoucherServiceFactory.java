package com.assignment.cryptocurrency.general;

import com.assignment.cryptocurrency.service.VoucherService;
import com.assignment.cryptocurrency.service.impl.InviteCodeServiceImpl;
import com.assignment.cryptocurrency.util.enums.VoucherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jackie on 06/12/2017.
 */
@Component
public class VoucherServiceFactory {

  private final InviteCodeServiceImpl inviteCodeService;

  @Autowired
  public VoucherServiceFactory(InviteCodeServiceImpl inviteCodeService) {
    this.inviteCodeService = inviteCodeService;
  }

  public VoucherService getInstance(VoucherType voucherType) {
    VoucherService voucherService = null;
    if (voucherType.equals(VoucherType.INVITE)) {
      voucherService = inviteCodeService;
    }
    return voucherService;
  }
}
