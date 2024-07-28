package com.marcos.hexagonal.application.core.usecase;

import com.marcos.hexagonal.application.core.domain.Customer;
import com.marcos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.marcos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.marcos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.marcos.hexagonal.application.ports.out.UpdateCustomerOutPutPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerOutPutPort updateCustomerOutPutPort
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutPutPort = updateCustomerOutPutPort;

    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdUseCase.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPutPort.update(customer);
    }


}
