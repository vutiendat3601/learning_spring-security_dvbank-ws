package com.datvutech.dvbankws.api.model.request;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDetailsRequest implements Serializable {
    private String contactName;

    private String contactEmail;

    private String subject;

    private String message;
}
