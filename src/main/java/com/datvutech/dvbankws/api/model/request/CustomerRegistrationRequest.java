package com.datvutech.dvbankws.api.model.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRegistrationRequest implements Serializable {
    private String name;
    
    private String email;

    private String mobileNumber;

    private String password;

    private Set<String> roles = new HashSet<>();
}
