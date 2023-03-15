package com.datvutech.dvbankws.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.response.LoanResponse;
import com.datvutech.dvbankws.data.entity.Loan;
import com.datvutech.dvbankws.shared.dto.LoanDto;


@Mapper
public interface LoanMapper {
    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    LoanResponse loanDtoToLoanResponse(LoanDto loanDto);
    
    @Mappings({
        @Mapping(target = "customer.password", ignore = true),
        @Mapping(target = "customer.roles", ignore = true)
    })
    LoanDto loanEntityToLoanDto(Loan loan);

    List<LoanDto> loanEntityToLoanDto(Iterable<Loan> loans);

    List<LoanResponse> loanDtoToLoanResponse(Iterable<LoanDto> loanDtos);
}
