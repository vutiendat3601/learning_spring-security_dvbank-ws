package com.datvutech.dvbankws.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.response.AccountTransactionResponse;
import com.datvutech.dvbankws.data.entity.AccountTransaction;
import com.datvutech.dvbankws.shared.dto.AccountTransactionDto;

@Mapper
public interface AccountTransactionMapper {
	AccountTransactionMapper INSTANCE = Mappers.getMapper(AccountTransactionMapper.class);

	@Mappings({
			@Mapping(target = "customer.password", ignore = true),
			@Mapping(target = "customer.roles", ignore = true),
			@Mapping(target = "account.customer.password", ignore = true),
			@Mapping(target = "account.customer.roles", ignore = true)
	})
	AccountTransactionDto accountTransactionEntityToAccountTransactionDto(
			AccountTransaction accTransaction);

	AccountTransactionResponse accountTransactionDtoToAccountTransactionResponse(
			AccountTransactionDto accTransactionDto);

	List<AccountTransactionDto> accountTransactionEntityToAccountTransactionDto(
			List<AccountTransaction> accTransactions);

	List<AccountTransactionResponse> accountTransactionDtoToAccountTransactionResponse(
			Iterable<AccountTransactionDto> accTransactionDtos);

}
