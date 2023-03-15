package com.datvutech.dvbankws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.data.entity.Account;
import com.datvutech.dvbankws.data.repository.AccountRepository;
import com.datvutech.dvbankws.mapper.AccountMapper;
import com.datvutech.dvbankws.service.AccountService;
import com.datvutech.dvbankws.shared.dto.AccountDto;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public AccountDto getAccount(long customerId) {
        Account account = accountRepo.findByCustomer(customerId).orElseThrow(
                () -> new ResourceNotFoundException("The customer don't have any bank account!"));
        AccountDto accountDto = AccountMapper.INSTANCE.accountEntityToAccountDto(account);
        return accountDto;
    }

}
