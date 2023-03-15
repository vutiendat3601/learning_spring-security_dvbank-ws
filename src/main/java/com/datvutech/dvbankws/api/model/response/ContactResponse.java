package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactResponse implements Serializable {
    private String contactName;

    private String contactEmail;

    private String subject;

    private String message;
}
