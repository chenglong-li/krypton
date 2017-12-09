package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jackie on 09/12/2017.
 */
@Entity
@Table(name = "offer")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Offer extends Model {

  private Integer coinId;
  private Double amount;
  private BigDecimal price;

  @Basic
  @Column(name = "coin_id")
  public Integer getCoinId() {
    return coinId;
  }

  public void setCoinId(Integer coinId) {
    this.coinId = coinId;
  }

  @Basic
  @Column(name = "amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Basic
  @Column(name = "price")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
