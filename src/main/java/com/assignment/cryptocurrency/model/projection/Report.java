package com.assignment.cryptocurrency.model.projection;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Report {

  private Integer totalUsers;
  private Integer totalTransfers;
  private Integer totalExchanges;

  public Integer getTotalUsers() {
    return totalUsers;
  }

  public void setTotalUsers(Integer totalUsers) {
    this.totalUsers = totalUsers;
  }

  public Integer getTotalTransfers() {
    return totalTransfers;
  }

  public void setTotalTransfers(Integer totalTransfers) {
    this.totalTransfers = totalTransfers;
  }

  public Integer getTotalExchanges() {
    return totalExchanges;
  }

  public void setTotalExchanges(Integer totalExchanges) {
    this.totalExchanges = totalExchanges;
  }
}
