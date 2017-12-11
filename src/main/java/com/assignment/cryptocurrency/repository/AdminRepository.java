package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "admin_list", path = "admins")
public interface AdminRepository extends JpaRepository<Admin, Integer> {

  Admin findAdminByUsernameAndPassword(
      @Param("username") String username, @Param("password") String password);

}
