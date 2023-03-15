package com.datvutech.dvbankws.api.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.response.LoanResponse;
import com.datvutech.dvbankws.mapper.LoanMapper;
import com.datvutech.dvbankws.service.LoanService;
import com.datvutech.dvbankws.shared.dto.LoanDto;

@RestController
public class LoanApi {
    @Autowired
    private LoanService loanService;

    @GetMapping("/myLoans")
    public List<LoanResponse> getLoans(@RequestParam("id") long customerId) {
        List<LoanDto> loanDtos = loanService.getLoansByCustomerId(customerId);
        List<LoanResponse> loanResps = LoanMapper.INSTANCE.loanDtoToLoanResponse(loanDtos);
        return loanResps;
    }
}
