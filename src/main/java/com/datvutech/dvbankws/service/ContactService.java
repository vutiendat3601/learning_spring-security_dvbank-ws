package com.datvutech.dvbankws.service;

import com.datvutech.dvbankws.shared.dto.ContactDto;

public interface ContactService {

    ContactDto saveContactInquiryDetails(ContactDto contactDto);
    
}
