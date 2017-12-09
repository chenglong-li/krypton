package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "wallet_list", path = "wallets")
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
