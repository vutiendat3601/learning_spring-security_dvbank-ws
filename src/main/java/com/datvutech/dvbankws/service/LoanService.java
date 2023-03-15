package com.datvutech.dvbankws.service;

import java.util.List;

import com.datvutech.dvbankws.shared.dto.LoanDto;

public interface LoanService {

    List<LoanDto> getLoansByCustomerId(long customerId);
}
