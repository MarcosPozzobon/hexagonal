package com.marcos.hexagonal.application.core.usecase;

import com.marcos.hexagonal.application.core.domain.Customer;
import com.marcos.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.marcos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.marcos.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.marcos.hexagonal.application.ports.out.SendCpfToValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfToValidationOutputPort sendCpfToValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfToValidationOutputPort sendCpfToValidationOutputPort
    ){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfToValidationOutputPort = sendCpfToValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfToValidationOutputPort.send(customer.getCpf());
    }

}
