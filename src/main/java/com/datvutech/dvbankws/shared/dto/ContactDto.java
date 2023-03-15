package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDto implements Serializable {
    private String contactId;
    
    private String contactName;
    
    private String contactEmail;
    
    private String subject;
    
    private String message;
}
