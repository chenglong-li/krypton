package com.assignment.cryptocurrency.util.enums;

/**
 * Created by Jackie on 06/12/2017.
 */
public enum VoucherStatus {
  VALID(1), INVALID(0);

  private final Integer voucherStatus;

  VoucherStatus(Integer voucherStatus) {
    this.voucherStatus = voucherStatus;
  }
}
