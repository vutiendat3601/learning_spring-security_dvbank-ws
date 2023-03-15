package com.datvutech.dvbankws.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datvutech.dvbankws.data.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("FROM Loan l WHERE l.customer.customerId = :customerId")
    List<Loan> findByCustomer(
            @Param("customerId") long customerId);
}
