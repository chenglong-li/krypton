package com.assignment.cryptocurrency.general;

import com.assignment.cryptocurrency.model.entity.Voucher;
import com.assignment.cryptocurrency.repository.VoucherRepository;
import com.assignment.cryptocurrency.util.enums.VoucherStatus;
import java.util.Date;
import javassist.NotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 06/12/2017.
 */
@Service
public abstract class AbstractVoucherService {

  private final VoucherRepository voucherRepository;

  @Autowired
  public AbstractVoucherService(VoucherRepository voucherRepository) {
    this.voucherRepository = voucherRepository;
  }

  protected Voucher valid(String code) throws NotFoundException {
    Voucher existed = voucherRepository.findByCode(code);
    if (existed == null) {
      throw new NotFoundException("The code is not existed!");
    }
    Date now = new Date();
    if (existed.getStartDate().after(now)
        || existed.getEndDate().before(now)
        || VoucherStatus.INVALID.name().equals(existed.getStatus())) {
      throw new ServiceException("The voucher is invalid!");
    }
    return existed;
  }
}
