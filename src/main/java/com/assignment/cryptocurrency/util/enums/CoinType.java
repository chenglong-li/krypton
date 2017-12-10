package com.assignment.cryptocurrency.util.enums;

public enum CoinType {
  Bitcoin(0), Walton(1);
  private final Integer coinType;

  CoinType(Integer coinType) {
    this.coinType = coinType;
  }
}
