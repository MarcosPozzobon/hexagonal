package com.marcos.hexagonal.adapters.in.controller;

import com.marcos.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.marcos.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.marcos.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.marcos.hexagonal.application.core.domain.Customer;
import com.marcos.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.marcos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.marcos.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.marcos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid final CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return findCustomerByIdInputPort.find(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable final String id,
            @Valid @RequestBody CustomerRequest customerRequest
    ){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
