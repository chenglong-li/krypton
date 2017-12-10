package com.assignment.cryptocurrency.model.entity;

import com.assignment.cryptocurrency.general.Model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Coin extends Model {

  private String name;

  @Basic
  @Column(name = "name", nullable = false, length = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
