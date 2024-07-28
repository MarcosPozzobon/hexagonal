package com.marcos.hexagonal.application.ports.out;

import com.marcos.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
