package com.assignment.cryptocurrency.util.enums;

/**
 * Created by Jackie on 05/12/2017.
 */
public enum UserStatus {
  NEW(0), WAITING(1), VERIFIED(2), BLOCKED(3);

  private final Integer statusCode;

  UserStatus(Integer statusCode) {
    this.statusCode = statusCode;
  }
}