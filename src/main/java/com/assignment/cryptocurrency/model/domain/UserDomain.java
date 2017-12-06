package com.assignment.cryptocurrency.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Jackie on 04/12/2017.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDomain {

  @NotEmpty(message = "The parameter 'first_name' can not be empty!")
  @Length(max = 100)
  private String firstName;

  @NotEmpty(message = "The parameter 'last_name' can not be empty!")
  @Length(max = 100)
  private String lastName;

  @NotEmpty(message = "The parameter 'username' can not be empty!")
  @Length(min = 3, max = 32)
  private String username;

  @NotEmpty(message = "The parameter 'password' can not be empty!")
  @Length(max = 32)
  private String password;

  @NotEmpty(message = "The parameter 'email' can not be empty!")
  @Length(max = 20)
  @Email(message = "It is not a valid email!")
  private String email;

  @Length(max = 20)
  private String mobile;


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

}
