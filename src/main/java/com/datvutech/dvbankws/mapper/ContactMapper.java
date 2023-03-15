package com.datvutech.dvbankws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.request.ContactDetailsRequest;
import com.datvutech.dvbankws.api.model.response.ContactResponse;
import com.datvutech.dvbankws.data.entity.Contact;
import com.datvutech.dvbankws.shared.dto.ContactDto;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactResponse contactDtoToContactResponse(ContactDto contactDto);

    Contact contactDtoToContactEntity(ContactDto contactDto);

    ContactDto contactEntityToContactDto(Contact contact);

    @Mappings({ @Mapping(target = "contactId", ignore = true) })
    ContactDto contactDetailsRequestToContactDto(ContactDetailsRequest contactDetailsReq);
}
