package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountTransactionResponse implements Serializable {

    @JsonProperty("transactionDt")
    private String transactionDate;

    private String transactionSummary;

    private String transactionType;

    private long closingBalance;
}
