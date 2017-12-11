package com.assignment.cryptocurrency.general;

import com.assignment.cryptocurrency.model.entity.Admin;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.repository.AdminRepository;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.repository.WalletRepository;
import com.assignment.cryptocurrency.util.enums.UserStatus;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Validation {

  private final UserRepository userRepository;
  private final WalletRepository walletRepository;
  private final AdminRepository adminRepository;

  private Validation(UserRepository userRepository,
      WalletRepository walletRepository,
      AdminRepository adminRepository) {
    this.userRepository = userRepository;
    this.walletRepository = walletRepository;
    this.adminRepository = adminRepository;
  }

  public User verifyByUserId(Integer userId) throws NotFoundException {
    User user = userRepository.findOne(userId);
    if (user == null) {
      throw new NotFoundException("The user is not found");
    }
    return user;
  }

  public Admin verifyByAdminId(Integer adminId) throws NotFoundException {
    Admin admin = adminRepository.findOne(adminId);
    if (admin == null) {
      throw new NotFoundException("The admin is not found");
    }
    return admin;
  }

  public String verifyUserStatus(Integer userId){
    User user = userRepository.findOne(userId);
    return user.getStatus();
  }

}
