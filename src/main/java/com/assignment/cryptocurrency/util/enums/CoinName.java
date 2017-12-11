package com.assignment.cryptocurrency.util.enums;

public enum CoinName {
  BITCOIN(0), ETHEREUM(1), LITECOIN(2), IOTA(3), NEO(4);
  private final Integer coinType;

  CoinName(Integer coinType) {
    this.coinType = coinType;
  }
}
