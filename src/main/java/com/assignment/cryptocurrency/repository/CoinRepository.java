package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "coin_list", path = "coins")
public interface CoinRepository extends JpaRepository<Coin, Integer> {

}
