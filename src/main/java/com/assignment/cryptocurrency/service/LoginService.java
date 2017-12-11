package com.assignment.cryptocurrency.service;

import com.assignment.cryptocurrency.model.entity.Admin;
import com.assignment.cryptocurrency.model.entity.User;
import javassist.NotFoundException;

/**
 * Created by Jackie on 08/12/2017.
 */
public interface LoginService {

  User login(String username, String password) throws NotFoundException;

  Admin loginAsAdmin(String username, String password) throws NotFoundException;

}
