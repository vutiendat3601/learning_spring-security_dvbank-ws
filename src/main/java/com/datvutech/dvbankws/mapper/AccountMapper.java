package com.datvutech.dvbankws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.response.AccountResponse;
import com.datvutech.dvbankws.data.entity.Account;
import com.datvutech.dvbankws.shared.dto.AccountDto;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mappings({
        @Mapping(target = "customer.password", ignore = true),
        @Mapping(target = "customer.roles", ignore = true)
    })
    AccountDto accountEntityToAccountDto(Account account);

    @Mappings({ @Mapping(target = "customer", source = "customer.name"),
            @Mapping(target = "customerEmail", source = "customer.email")
    })
    AccountResponse accountDtoToAccountResponse(AccountDto accountDto);

}
