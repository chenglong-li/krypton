package com.assignment.cryptocurrency.util.enums;

/**
 * Created by Jackie on 06/12/2017.
 */
public enum VoucherType {
  INVITE(0), TOPUP(1), GIFT(2);

  private final Integer voucherType;

  VoucherType(Integer voucherType) {
    this.voucherType = voucherType;
  }
}
