package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.entity.Admin;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.repository.AdminRepository;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.service.LoginService;
import com.assignment.cryptocurrency.util.enums.UserStatus;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jackie on 08/12/2017.
 */
@Service
public class LoginServiceImpl implements LoginService {

  private final UserRepository userRepository;
  private final AdminRepository adminRepository;


  @Autowired
  public LoginServiceImpl(UserRepository userRepository,
      AdminRepository adminRepository) {
    this.userRepository = userRepository;
    this.adminRepository = adminRepository;
  }

  @Override
  public User login(String username, String password) throws NotFoundException {
    User user = userRepository.findUserByUsernameAndPassword(username, password);
    if (user == null) {
      throw new NotFoundException("User not found");
    }
    if (UserStatus.BLOCKED.name().equalsIgnoreCase(user.getStatus())) {
      throw new IllegalArgumentException("The user is blocked");
    }
    return user;
  }

  @Override
  public Admin loginAsAdmin(String username, String password) throws NotFoundException {
    Admin admin = adminRepository.findAdminByUsernameAndPassword(username, password);
    if (admin == null) {
      throw new NotFoundException("Admin not found");
    }
    return admin;
  }
}
