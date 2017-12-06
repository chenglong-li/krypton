package com.assignment.cryptocurrency.general;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Jackie on 04/12/2017.
 */
@MappedSuperclass
public class Model implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  //  @GeneratedValue(generator = "system-uuid")
  //  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
