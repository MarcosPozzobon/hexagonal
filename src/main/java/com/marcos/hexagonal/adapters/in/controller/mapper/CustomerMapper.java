package com.marcos.hexagonal.adapters.in.controller.mapper;

import com.marcos.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.marcos.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.marcos.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "cpfValid", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

}
