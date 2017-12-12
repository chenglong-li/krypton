package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Jackie on 09/12/2017.
 */
@Entity
@Table(name = "wallet")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Wallet extends Model {

  private Integer coinId;
  private String address;
  private BigDecimal amount;
  @Column(name = "user_id")
  private Integer userId;
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "user_id")
//  @ManyToOne(fetch = FetchType.LAZY)
//  private User user;

  @Basic
  @Column(name = "coin_id")
  public Integer getCoinId() {
    return coinId;
  }

  public void setCoinId(Integer coinId) {
    this.coinId = coinId;
  }

  @Basic
  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Column(name = "amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }
}
