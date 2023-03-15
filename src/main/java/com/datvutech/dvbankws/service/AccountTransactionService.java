package com.datvutech.dvbankws.service;

import java.util.List;

import com.datvutech.dvbankws.shared.dto.AccountTransactionDto;

public interface AccountTransactionService {

    List<AccountTransactionDto> getAccountTransactionsByCustomerId(long customerId);
}
