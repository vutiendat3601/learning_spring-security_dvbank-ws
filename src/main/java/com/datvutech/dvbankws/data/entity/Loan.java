package com.datvutech.dvbankws.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "loans")
@Entity
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanNumber;

    private LocalDateTime startDate;

    private String loanType;

    private long totalLoan;

    private long paidAmount;

    private long outstandingAmount;

    private LocalDateTime createdDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
}
