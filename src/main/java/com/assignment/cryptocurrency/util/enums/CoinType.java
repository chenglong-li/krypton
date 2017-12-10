package com.assignment.cryptocurrency.util.enums;

public enum CoinType {
  Bitcoin(0), Ethereum(1), Litecoin(2), Iota(3), Neo(4);
  private final Integer coinType;

  CoinType(Integer coinType) {
    this.coinType = coinType;
  }
}
