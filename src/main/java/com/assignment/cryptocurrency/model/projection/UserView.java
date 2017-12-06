package com.assignment.cryptocurrency.model.projection;

import com.assignment.cryptocurrency.model.entity.User;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by Jackie on 05/12/2017.
 */
@Projection(name = "userView", types = {User.class})
public interface UserView {

  String getFirstName();

  String getLastName();

  String getUsername();

  String getPassword();

  String getEmail();

  String getMobile();

  String getStatus();
}
