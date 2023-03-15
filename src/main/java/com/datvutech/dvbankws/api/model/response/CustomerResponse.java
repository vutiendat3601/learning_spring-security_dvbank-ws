package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerResponse implements Serializable {

    @JsonProperty("id")
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;

}
