package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 05/12/2017.
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findByUsername(String username) {
    User user = new User();
    user.setUsername(username);
    Example<User> example = Example.of(user);
    return userRepository.findOne(example);
  }

  @Override
  public User findOne(Integer id) {
    return userRepository.findOne(id);
  }

  @Override
  public Page<User> findAll(User user, Pageable pageable) {
    Example<User> example = Example.of(user);
    return userRepository.findAll(example, pageable);
  }

  @Override
  public User createOrUpdate(User user) {
    return userRepository.save(user);
  }
}
