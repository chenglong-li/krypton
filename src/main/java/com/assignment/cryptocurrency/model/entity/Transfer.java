package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transfer")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Transfer extends Model {

  private Integer originUserId;
  private Integer destUserId;
  private String cryptonType;
  private BigDecimal cryptonAmount;
  private BigDecimal cryptonPrice;
  private Date createTime;

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

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
