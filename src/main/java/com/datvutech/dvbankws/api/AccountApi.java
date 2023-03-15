package com.datvutech.dvbankws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.response.AccountResponse;
import com.datvutech.dvbankws.mapper.AccountMapper;
import com.datvutech.dvbankws.service.AccountService;
import com.datvutech.dvbankws.shared.dto.AccountDto;

@RestController
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @GetMapping("/myAccount")
    public AccountResponse getAccountDetails(@RequestParam("id") long customerId) {
        AccountDto accountDto = accountService.getAccount(customerId);
        AccountResponse accountResp = AccountMapper
                .INSTANCE.accountDtoToAccountResponse(accountDto);
        return accountResp;
    }
}
