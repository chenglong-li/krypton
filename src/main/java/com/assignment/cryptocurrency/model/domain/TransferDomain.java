package com.assignment.cryptocurrency.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;

/**
 * Created by Jackie on 04/12/2017.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransferDomain {

  private String destUsername;
  private String cryptonType;
  private BigDecimal cryptonAmount;
  private BigDecimal cryptonPrice;

  public String getDestUsername() {
    return destUsername;
  }

  public void setDestUsername(String destUsername) {
    this.destUsername = destUsername;
  }

  public String getCryptonType() {
    return cryptonType;
  }

  public void setCryptonType(String cryptonType) {
    this.cryptonType = cryptonType;
  }

  public BigDecimal getCryptonAmount() {
    return cryptonAmount;
  }

  public void setCryptonAmount(BigDecimal cryptonAmount) {
    this.cryptonAmount = cryptonAmount;
  }

  public BigDecimal getCryptonPrice() {
    return cryptonPrice;
  }

  public void setCryptonPrice(BigDecimal cryptonPrice) {
    this.cryptonPrice = cryptonPrice;
  }
}
