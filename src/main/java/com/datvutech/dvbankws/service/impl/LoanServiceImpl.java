package com.datvutech.dvbankws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.data.entity.Loan;
import com.datvutech.dvbankws.data.repository.LoanRepository;
import com.datvutech.dvbankws.mapper.LoanMapper;
import com.datvutech.dvbankws.service.LoanService;
import com.datvutech.dvbankws.shared.dto.LoanDto;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepo;

    @Override
    public List<LoanDto> getLoansByCustomerId(long customerId) {
        List<Loan> loans = loanRepo.findByCustomer(customerId);
        List<LoanDto> loanDtos = LoanMapper.INSTANCE.loanEntityToLoanDto(loans);
        return loanDtos;
    }

}
