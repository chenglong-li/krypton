package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Wallet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "wallet_list", path = "wallets")
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

  @RestResource
  List<Wallet> findByUserId(@Param("userId") Integer userId);

  @RestResource(exported = false)
  Wallet findByUserIdAndCoinId(@Param("userId") Integer userId,
      @Param("coinId") Integer coinId);
}
