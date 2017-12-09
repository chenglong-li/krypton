package com.assignment.cryptocurrency.service;

import com.assignment.cryptocurrency.model.entity.Voucher;
import javassist.NotFoundException;

/**
 * Created by Jackie on 06/12/2017.
 */
public interface VoucherService {
  Voucher verify(String code) throws NotFoundException;

  Voucher save(Voucher voucher);
}
