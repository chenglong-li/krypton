package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Exchange;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "exchange_list", path = "exchanges")
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

  List<Exchange> findByUserId(@Param("userId") Integer userId);
}
