package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse implements Serializable {
    private Long accountNumber;

    private String customer;

    private String customerEmail;

    private String accountType;

    private String branchAddress;

    private String createdDate;
}
