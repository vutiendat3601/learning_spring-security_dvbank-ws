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
@Table(name = "accounts")
@Entity
public class Account implements Serializable {

    @Id
    private Long accountNumber;

    private String accountType;

    private String branchAddress;

    private LocalDateTime createdDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
}