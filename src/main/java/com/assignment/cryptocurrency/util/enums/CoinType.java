package com.assignment.cryptocurrency.util.enums;

public enum CoinType {
  BITCOIN(0), ETHEREUM(1), LITECOIN(2), IOTA(3), NEO(4);
  private final Integer coinType;

  CoinType(Integer coinType) {
    this.coinType = coinType;
  }
}
