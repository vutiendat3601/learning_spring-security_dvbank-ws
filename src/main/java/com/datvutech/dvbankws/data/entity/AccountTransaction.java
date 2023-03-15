package com.datvutech.dvbankws.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "account_transactions")
@Entity
public class AccountTransaction implements Serializable {
    @Id
    private String transactionId;

    private LocalDateTime transactionDate;

    private String transactionSummary;

    private String transactionType;

    private long transactionAmount;

    private long closingBalance;

    private LocalDateTime createdDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
    private Account account;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
}
