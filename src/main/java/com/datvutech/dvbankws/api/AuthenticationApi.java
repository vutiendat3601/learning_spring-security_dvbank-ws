package com.datvutech.dvbankws.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.request.CustomerRegistrationRequest;
import com.datvutech.dvbankws.api.model.response.CustomerResponse;
import com.datvutech.dvbankws.mapper.CustomerMapper;
import com.datvutech.dvbankws.service.CustomerService;
import com.datvutech.dvbankws.shared.dto.CustomerDto;

@RestController
public class AuthenticationApi {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> registerUser(
            @RequestBody CustomerRegistrationRequest customerRegistrationReq) {
        CustomerDto customerDto = CustomerMapper.INSTANCE
                .customerRegistrationRequestToCustomerDto(customerRegistrationReq);
        customerDto = customerService.registerCustomer(customerDto);
        CustomerResponse customerResp = CustomerMapper.INSTANCE.customerDtoToUserResponse(customerDto);
        return ResponseEntity.created(URI.create("/user/" + customerResp.getEmail()))
                .body(customerResp);
    }

    @GetMapping("/user")
    public CustomerResponse getUserDetailsAfterLogin(Authentication authentication) {
        String email = authentication.getName();
        CustomerDto customerDto = customerService.getCustomer(email);
        CustomerResponse userResp = CustomerMapper.INSTANCE.customerDtoToUserResponse(customerDto);
        return userResp;
    }
}
