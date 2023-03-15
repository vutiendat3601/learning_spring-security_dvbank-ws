package com.datvutech.dvbankws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.data.entity.AccountTransaction;
import com.datvutech.dvbankws.data.repository.AccountTransactionRepository;
import com.datvutech.dvbankws.mapper.AccountTransactionMapper;
import com.datvutech.dvbankws.service.AccountTransactionService;
import com.datvutech.dvbankws.shared.dto.AccountTransactionDto;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    @Autowired
    private AccountTransactionRepository accTransactionRepo;

    @Override
    public List<AccountTransactionDto> getAccountTransactionsByCustomerId(long customerId) {
        List<AccountTransaction> accTransactions = accTransactionRepo
                .findByCustomerIdOrderByTransactionDateDesc(customerId);
        List<AccountTransactionDto> accTransactionDtos = AccountTransactionMapper.INSTANCE
                .accountTransactionEntityToAccountTransactionDto(accTransactions);
        return accTransactionDtos;
    }

}
