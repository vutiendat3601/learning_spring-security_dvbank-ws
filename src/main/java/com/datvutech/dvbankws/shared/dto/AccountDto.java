package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {
    private Long accountNumber;

    private CustomerDto customer;

    private String accountType;

    private String branchAddress;

    private String createdDate;
}
