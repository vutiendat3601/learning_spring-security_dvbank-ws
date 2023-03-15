package com.datvutech.dvbankws.service;

import com.datvutech.dvbankws.shared.dto.CustomerDto;

public interface CustomerService {

    CustomerDto registerCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(String email);
    
}
