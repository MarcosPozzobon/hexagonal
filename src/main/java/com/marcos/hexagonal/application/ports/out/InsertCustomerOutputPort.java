package com.marcos.hexagonal.application.ports.out;

import com.marcos.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
