package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "voucher_list", path = "vouchers")
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {

  @RestResource(exported = false)
  Voucher save(Voucher voucher);

  Voucher findByCode(@Param("code") String code);

  Voucher findByUserId(@Param("userId") Integer userId);

}
