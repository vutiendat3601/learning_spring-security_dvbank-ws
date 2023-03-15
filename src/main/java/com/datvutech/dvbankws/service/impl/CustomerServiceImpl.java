package com.datvutech.dvbankws.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.data.entity.Authority;
import com.datvutech.dvbankws.data.entity.Customer;
import com.datvutech.dvbankws.data.repository.AuthorityRepository;
import com.datvutech.dvbankws.data.repository.CustomerRepository;
import com.datvutech.dvbankws.exception.UserServiceException;
import com.datvutech.dvbankws.mapper.CustomerMapper;
import com.datvutech.dvbankws.service.CustomerService;
import com.datvutech.dvbankws.shared.dto.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepo;

    @Override
    public CustomerDto registerCustomer(CustomerDto customerDto) {
        Optional<Customer> customerOpt = customerRepo.findByEmail(customerDto.getEmail());
        if (customerOpt.isPresent()) {
            throw new UserServiceException("Email was taken!", HttpStatus.CONFLICT);
        }
        String pwd = passwordEncoder.encode(customerDto.getPassword());
        customerDto.setPwd(pwd);
        customerDto.setCreatedDate(LocalDateTime.now());
        Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomerEntity(customerDto);
        customer = customerRepo.save(customer);
        for (String role : customerDto.getRoles()) {
            Authority authority = new Authority(role, customer);
            authorityRepo.save(authority);
        }

        customerDto = CustomerMapper.INSTANCE.customerEntityToCustomerDto(customer);
        return customerDto;
    }

    @Override
    public CustomerDto getCustomer(String email) {
        Customer customer = customerRepo.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User not found!"));
        CustomerDto customerDto = CustomerMapper.INSTANCE.customerEntityToCustomerDto(customer);
        return customerDto;
    }
}
