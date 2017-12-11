package com.assignment.cryptocurrency.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;

/**
 * Created by Jackie on 04/12/2017.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransferDomain {

  private Integer originUserId;
  private Integer destUserId;
  private String cryptonType;
  private BigDecimal cryptonAmount;
  private BigDecimal cryptonPrice;

  public Integer getOriginUserId() {
    return originUserId;
  }

  public void setOriginUserId(Integer originUserId) {
    this.originUserId = originUserId;
  }

  public Integer getDestUserId() {
    return destUserId;
  }

  public void setDestUserId(Integer destUserId) {
    this.destUserId = destUserId;
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
