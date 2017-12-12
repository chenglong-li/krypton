package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.assignment.cryptocurrency.util.enums.CoinName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "exchange")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Exchange extends Model {

  private CoinName originType;
  private CoinName destType;
  private BigDecimal originAmount;
  private BigDecimal destAmount;
  private BigDecimal originPrice;
  private BigDecimal destPrice;
  @Column(name = "user_id")
  private Integer userId;
  private Date createTime;

  public CoinName getOriginType() {
    return originType;
  }

  public void setOriginType(CoinName originType) {
    this.originType = originType;
  }

  public CoinName getDestType() {
    return destType;
  }

  public void setDestType(CoinName destType) {
    this.destType = destType;
  }

  @Basic
  @Column(name = "origin_amount", nullable = true, precision = 0)
  public BigDecimal getOriginAmount() {
    return originAmount;
  }

  public void setOriginAmount(BigDecimal originAmount) {
    this.originAmount = originAmount;
  }

  @Basic
  @Column(name = "dest_amount", nullable = false, precision = 0)
  public BigDecimal getDestAmount() {
    return destAmount;
  }

  public void setDestAmount(BigDecimal destAmount) {
    this.destAmount = destAmount;
  }

  @Basic
  @Column(name = "origin_price", nullable = false, precision = 0)
  public BigDecimal getOriginPrice() {
    return originPrice;
  }

  public void setOriginPrice(BigDecimal originPrice) {
    this.originPrice = originPrice;
  }

  @Basic
  @Column(name = "dest_price", nullable = false, precision = 0)
  public BigDecimal getDestPrice() {
    return destPrice;
  }

  public void setDestPrice(BigDecimal destPrice) {
    this.destPrice = destPrice;
  }

  @Basic
  @Column(name = "user_id", nullable = false)
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
