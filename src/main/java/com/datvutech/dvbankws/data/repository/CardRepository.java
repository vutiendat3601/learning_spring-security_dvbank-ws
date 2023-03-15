package com.datvutech.dvbankws.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datvutech.dvbankws.data.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("FROM Card c WHERE c.customer.customerId = :customerId")
    List<Card> findByCustomer(@Param("customerId") long customerId);
}
