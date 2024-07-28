package com.marcos.hexagonal.config;

import com.marcos.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.marcos.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.marcos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.marcos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdInputPort, deleteCustomerByIdAdapter);
    }

}
