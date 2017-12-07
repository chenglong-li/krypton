package com.assignment.cryptocurrency.service;

import com.assignment.cryptocurrency.model.entity.User;
import javassist.NotFoundException;

/**
 * Created by Jackie on 06/12/2017.
 */
public interface RegisterService {

  User register(User user, String inviteCode) throws NotFoundException;
}
