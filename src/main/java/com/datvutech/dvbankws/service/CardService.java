package com.datvutech.dvbankws.service;

import java.util.List;

import com.datvutech.dvbankws.shared.dto.CardDto;

public interface CardService {

    List<CardDto> getCardsByCustomerId(long customerId);
    
}
