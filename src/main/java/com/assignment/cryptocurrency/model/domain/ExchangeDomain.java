package com.assignment.cryptocurrency.model.domain;

import com.assignment.cryptocurrency.util.enums.CoinType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;

/**
 * Created by Jackie on 04/12/2017.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ExchangeDomain {

  private CoinType originType;

  private CoinType destType;

  private BigDecimal originAmount;

  private BigDecimal originPrice;

  private BigDecimal destPrice;

  public CoinType getOriginType() {
    return originType;
  }

  public void setOriginType(CoinType originType) {
    this.originType = originType;
  }

  public CoinType getDestType() {
    return destType;
  }

  public void setDestType(CoinType destType) {
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

}
