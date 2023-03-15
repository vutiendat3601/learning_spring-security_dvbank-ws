package com.datvutech.dvbankws.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datvutech.dvbankws.data.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("FROM Account a WHERE a.customer.customerId = :customerId")
    Optional<Account> findByCustomer(
            @Param("customerId") long customerId);
}
