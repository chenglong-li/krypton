package com.assignment.cryptocurrency.service.impl;

import com.assignment.cryptocurrency.model.projection.Report;
import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.repository.AdminRepository;
import com.assignment.cryptocurrency.repository.ExchangeRepository;
import com.assignment.cryptocurrency.repository.TransferRepository;
import com.assignment.cryptocurrency.repository.UserRepository;
import com.assignment.cryptocurrency.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

  private final UserRepository userRepository;
  private final AdminRepository adminRepository;
  private final TransferRepository transferRepository;
  private final ExchangeRepository exchangeRepository;

  public AdminServiceImpl(UserRepository userRepository,
      AdminRepository adminRepository,
      TransferRepository transferRepository,
      ExchangeRepository exchangeRepository) {
    this.userRepository = userRepository;
    this.adminRepository = adminRepository;
    this.transferRepository = transferRepository;
    this.exchangeRepository = exchangeRepository;
  }

  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public Report viewReport() {
    Report report = new Report();
    Integer totalUsers = userRepository.findAll().size();
    Integer totalTransfers = transferRepository.findAll().size();
    Integer totalExchanges= exchangeRepository.findAll().size();
    report.setTotalExchanges(totalExchanges);
    report.setTotalTransfers(totalTransfers);
    report.setTotalUsers(totalUsers);

    return report;
  }
}
