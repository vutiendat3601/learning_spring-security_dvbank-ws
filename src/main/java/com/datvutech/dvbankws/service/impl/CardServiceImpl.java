package com.datvutech.dvbankws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.data.entity.Card;
import com.datvutech.dvbankws.data.repository.CardRepository;
import com.datvutech.dvbankws.mapper.CardMapper;
import com.datvutech.dvbankws.service.CardService;
import com.datvutech.dvbankws.shared.dto.CardDto;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository cardRepo;

    @Override
    public List<CardDto> getCardsByCustomerId(long customerId) {
        List<Card> cards = cardRepo.findByCustomer(customerId);
        List<CardDto> cardDtos = CardMapper.INSTANCE.cardEntityToCardDto(cards);
        return cardDtos;
    }
    
}
