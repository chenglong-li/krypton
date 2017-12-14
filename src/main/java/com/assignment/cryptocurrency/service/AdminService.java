package com.assignment.cryptocurrency.service;

import com.assignment.cryptocurrency.model.projection.Report;
import com.assignment.cryptocurrency.model.entity.User;

public interface AdminService {

  User updateUser(User user);

  Report viewReport();


}
