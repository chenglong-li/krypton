package com.assignment.cryptocurrency.util;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailUtil {

  public static void sendSimpleMail(SimpleMailMessage message) {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setDefaultEncoding("utf-8");
    mailSender.setHost("smtp.sina.com");
    mailSender.setPort(25);
    mailSender.setProtocol("smtp");
    mailSender.setUsername("longestar@sina.com");
    mailSender.setPassword("1234");
    mailSender.send(message);
  }

}
