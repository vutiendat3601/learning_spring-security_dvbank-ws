package com.datvutech.dvbankws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.response.AccountTransactionResponse;
import com.datvutech.dvbankws.mapper.AccountTransactionMapper;
import com.datvutech.dvbankws.service.AccountTransactionService;
import com.datvutech.dvbankws.shared.dto.AccountTransactionDto;

@RestController
public class AccountTransactionApi {

    @Autowired
    private AccountTransactionService accTransactionService;

    @GetMapping("/myBalance")
    public List<AccountTransactionResponse> getAccountTransactionsByCustomerId(
            @RequestParam("id") long customerId) {
        List<AccountTransactionDto> accTransactionDtos = accTransactionService
                .getAccountTransactionsByCustomerId(customerId);
        List<AccountTransactionResponse> accTransactionResps = AccountTransactionMapper.INSTANCE
                .accountTransactionDtoToAccountTransactionResponse(accTransactionDtos);
        return accTransactionResps;
    }
}
