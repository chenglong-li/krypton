package com.assignment.cryptocurrency.service;

import com.assignment.cryptocurrency.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Jackie on 05/12/2017.
 */
public interface UserService {

  User findByUsername(String username);

  User findOne(Integer id);

  Page<User> findAll(User user, Pageable pageable);

  User createOrUpdate(User user);

}
