package com.datvutech.dvbankws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.request.CustomerRegistrationRequest;
import com.datvutech.dvbankws.api.model.response.CustomerResponse;
import com.datvutech.dvbankws.data.entity.Customer;
import com.datvutech.dvbankws.shared.dto.CustomerDto;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	@Mappings({
			@Mapping(target = "createdDate", ignore = true),
			@Mapping(target = "customerId", ignore = true),
			@Mapping(target = "pwd", ignore = true)
	})
	CustomerDto customerRegistrationRequestToCustomerDto(
			CustomerRegistrationRequest customerRegistrationReq);

	Customer customerDtoToCustomerEntity(CustomerDto customerDto);

	@Mappings({
		@Mapping(target = "roles", ignore = true),
		@Mapping(target = "password", ignore = true)
	})
	CustomerDto customerEntityToCustomerDto(Customer customer);

	CustomerResponse customerDtoToUserResponse(CustomerDto customerDto);
}
