package com.assignment.cryptocurrency.repository;

import com.assignment.cryptocurrency.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Jackie on 05/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "offer_list", path = "offers")
public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
