package com.datvutech.dvbankws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.app.util.TextUtils;
import com.datvutech.dvbankws.data.entity.Contact;
import com.datvutech.dvbankws.data.repository.ContactRepository;
import com.datvutech.dvbankws.mapper.ContactMapper;
import com.datvutech.dvbankws.service.ContactService;
import com.datvutech.dvbankws.shared.dto.ContactDto;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepo;

    @Autowired
    private TextUtils textUtils;

    @Override
    public ContactDto saveContactInquiryDetails(ContactDto contactDto) {
        contactDto.setContactId(textUtils.genRandomTextNumber(999L, 1_000_000_000L));
        Contact contact = ContactMapper.INSTANCE.contactDtoToContactEntity(contactDto);
        contact = contactRepo.save(contact);
        contactDto = ContactMapper.INSTANCE.contactEntityToContactDto(contact);
        return contactDto;
    }

}
