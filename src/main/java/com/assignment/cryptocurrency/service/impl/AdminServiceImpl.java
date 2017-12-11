package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.repository.AdminRepository;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

  private final UserRepository userRepository;
  private final AdminRepository adminRepository;

  public AdminServiceImpl(UserRepository userRepository,
      AdminRepository adminRepository) {
    this.userRepository = userRepository;
    this.adminRepository = adminRepository;
  }

  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }
}
