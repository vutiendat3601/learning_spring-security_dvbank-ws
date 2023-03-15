package com.datvutech.dvbankws.service;

import com.datvutech.dvbankws.shared.dto.AccountDto;

public interface AccountService {
    AccountDto getAccount(long customerId);
}
