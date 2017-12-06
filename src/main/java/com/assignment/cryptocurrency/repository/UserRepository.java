package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.User;
import com.assignment.cryptocurrency.model.projection.UserView;
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

  @RestResource(path = "users")
  List<User> findByUsernameContaining(@Param(value = "username") String username);
}
