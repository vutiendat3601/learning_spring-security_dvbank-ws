package com.datvutech.dvbankws.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.response.CardResponse;
import com.datvutech.dvbankws.data.entity.Card;
import com.datvutech.dvbankws.shared.dto.CardDto;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardResponse cardDtoToCardResponse(CardDto cardDto);

    Card cardDtoToCardEntity(CardDto cardDto);

    @Mappings({
        @Mapping(target = "customer.password", ignore = true),
        @Mapping(target = "customer.roles", ignore = true)
    })
    CardDto cardEntityToCardDto(Card card);

    List<CardDto> cardEntityToCardDto(Iterable<Card> Cards);

    List<CardResponse> cardDtoToCardResponse(Iterable<CardDto> CardDtos);
}
