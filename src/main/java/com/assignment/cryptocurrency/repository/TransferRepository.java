package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Transfer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "transfer_list", path = "transfers")
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

  List<Transfer> findByOriginUserId(@Param("userId") Integer userId);
  List<Transfer> findByDestUserId(@Param("userId") Integer userId);
}
