package com.datvutech.dvbankws.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datvutech.dvbankws.data.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Query(" FROM Authority a WHERE a.customer.customerId = :customerId")
    Iterable<Authority> findByCustomer(
            @Param("customerId") long customerId);
}
