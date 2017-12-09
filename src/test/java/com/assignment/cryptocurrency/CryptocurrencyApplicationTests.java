package com.assignment.cryptocurrency;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.service.LoginService;
import java.util.Random;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptocurrencyApplicationTests {

  @Autowired
  private LoginService loginService;

  @Test
  public void contextLoads() throws NotFoundException {
    User user = loginService.login("chenglong", "1234");
    System.out.println(user.getFirstName());
  }

}
