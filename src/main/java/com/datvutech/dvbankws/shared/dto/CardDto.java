package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDto implements Serializable {
    private Long cardId;

    private String cardNumber;

    private String cardType;

    private long totalLimit;

    private Long usedAmount;

    private Long availableAmount;

    private LocalDateTime createdDate;
    
    private CustomerDto customer;
}
