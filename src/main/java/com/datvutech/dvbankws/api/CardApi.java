package com.datvutech.dvbankws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.response.CardResponse;
import com.datvutech.dvbankws.mapper.CardMapper;
import com.datvutech.dvbankws.service.CardService;
import com.datvutech.dvbankws.shared.dto.CardDto;

@RestController
public class CardApi {

    @Autowired
    private CardService cardService;

    @GetMapping("/myCards")
    public List<CardResponse> getCardsByCustomerId(
            @RequestParam("id") long customerId) {
        List<CardDto> cardDtos = cardService.getCardsByCustomerId(customerId);
        List<CardResponse> cardResps = CardMapper.INSTANCE.cardDtoToCardResponse(cardDtos);
        return cardResps;
    }
}
