package com.marcos.hexagonal.adapters.out.client.mapper;

import com.marcos.hexagonal.adapters.out.client.response.AddressResponse;
import com.marcos.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
