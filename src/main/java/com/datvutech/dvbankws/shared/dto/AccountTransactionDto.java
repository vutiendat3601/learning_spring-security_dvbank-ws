package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountTransactionDto implements Serializable {
    private String transactionId;
    
    private AccountDto account;
    
    private CustomerDto customer;
    
    private Date transactionDate;
    
    private String transactionSummary;
    
    private String transactionType;
    
    private long transactionAmount;
    
    private long closingBalance;
    
    private String createdDate;
}
