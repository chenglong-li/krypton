package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.service.LoginService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 08/12/2017.
 */
@Service
public class LoginServiceImpl implements LoginService {

  private final UserRepository userRepository;


  @Autowired
  public LoginServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User login(String username, String password) throws NotFoundException {
    User user = userRepository.findByUsernameAndPasswordEquals(username, password);
    if (user == null) {
      throw new NotFoundException("User not found");
    }
    return user;
  }
}
