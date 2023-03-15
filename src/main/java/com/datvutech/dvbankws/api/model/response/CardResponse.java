package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardResponse implements Serializable {
    private String cardNumber;

    private String cardType;

    private long totalLimit;

    @JsonProperty("amountUsed")
    private Long usedAmount;

    private Long availableAmount;

}
