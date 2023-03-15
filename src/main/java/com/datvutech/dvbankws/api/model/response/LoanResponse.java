package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanResponse implements Serializable {

    @JsonProperty("startDt")
    private LocalDate startDate;

    private String loanType;

    private long totalLoan;

    @JsonProperty("amountPaid")
    private long paidAmount;

    @JsonProperty("outstandingAmount")
    private long outstandingAmount;
}
