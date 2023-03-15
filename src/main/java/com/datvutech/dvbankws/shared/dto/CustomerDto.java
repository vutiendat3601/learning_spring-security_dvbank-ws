package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerDto implements Serializable {
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;

    private String password;

    private String pwd;

    private Set<String> roles;

    private LocalDateTime createdDate;
}
