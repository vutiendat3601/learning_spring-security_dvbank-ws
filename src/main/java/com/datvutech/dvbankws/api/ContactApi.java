package com.datvutech.dvbankws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.request.ContactDetailsRequest;
import com.datvutech.dvbankws.api.model.response.ContactResponse;
import com.datvutech.dvbankws.mapper.ContactMapper;
import com.datvutech.dvbankws.service.ContactService;
import com.datvutech.dvbankws.shared.dto.ContactDto;

@RestController
public class ContactApi {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ContactResponse saveContactInquiryDetails(
            @RequestBody ContactDetailsRequest contactDetailsReq) {
        ContactDto contactDto = ContactMapper.INSTANCE
                .contactDetailsRequestToContactDto(contactDetailsReq);
        contactDto = contactService.saveContactInquiryDetails(contactDto);
        ContactResponse contactResp = ContactMapper.INSTANCE
                .contactDtoToContactResponse(contactDto);
        return contactResp;
    }
}
