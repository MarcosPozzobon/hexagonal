package com.marcos.hexagonal.application.ports.in;

import com.marcos.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
