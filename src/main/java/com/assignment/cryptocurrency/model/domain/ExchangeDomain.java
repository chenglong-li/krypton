package com.assignment.cryptocurrency.model.domain;

import com.assignment.cryptocurrency.util.enums.CoinName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;

/**
 * Created by Jackie on 04/12/2017.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ExchangeDomain {

  private String originType;

  private String destType;

  private BigDecimal originAmount;
  private BigDecimal destAmount;

  private BigDecimal originPrice;

  private BigDecimal destPrice;

  public String getOriginType() {
    return originType;
  }

  public void setOriginType(String originType) {
    this.originType = originType;
  }

  public String getDestType() {
    return destType;
  }

  public void setDestType(String destType) {
    this.destType = destType;
  }

  public BigDecimal getOriginAmount() {
    return originAmount;
  }

  public void setOriginAmount(BigDecimal originAmount) {
    this.originAmount = originAmount;
  }

  public BigDecimal getOriginPrice() {
    return originPrice;
  }

  public void setOriginPrice(BigDecimal originPrice) {
    this.originPrice = originPrice;
  }

  public BigDecimal getDestPrice() {
    return destPrice;
  }

  public void setDestPrice(BigDecimal destPrice) {
    this.destPrice = destPrice;
  }

  public BigDecimal getDestAmount() {
    return destAmount;
  }

  public void setDestAmount(BigDecimal destAmount) {
    this.destAmount = destAmount;
  }
}
