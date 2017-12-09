package com.assignment.cryptocurrency.service;

import javassist.NotFoundException;

/**
 * Created by Jackie on 08/12/2017.
 */
public interface InviteService {

  void invite(Integer userId, String email) throws NotFoundException;
}
