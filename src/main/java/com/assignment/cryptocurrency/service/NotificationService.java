package com.assignment.cryptocurrency.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Jackie on 08/12/2017.
 */
public interface NotificationService {

  void sendEmail(SimpleMailMessage message);

}
