package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanDto implements Serializable {
    private Long loanNumber;

    private LocalDateTime startDate;

    private String loanType;

    private long totalLoan;

    private long paidAmount;

    private long outstandingAmount;

    private LocalDateTime createdDate;

    private CustomerDto customer;
}
