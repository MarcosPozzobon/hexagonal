package com.marcos.hexagonal.adapters.out;

import com.marcos.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.marcos.hexagonal.adapters.out.repository.CustomerRepository;
import com.marcos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.marcos.hexagonal.application.core.domain.Customer;
import com.marcos.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
