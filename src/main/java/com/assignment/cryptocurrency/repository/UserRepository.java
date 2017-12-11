package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.model.projection.UserView;
import com.assignment.cryptocurrency.util.enums.UserStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "user_list", path = "Users", excerptProjection = UserView.class)
public interface UserRepository extends JpaRepository<User, Integer> {

  User findUserByUsername(String username);

  User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

  List<User> findUsersByUsernameContaining(@Param("username") String username);

  List<User> findUsersByStatus(@Param("status") String status);
}
