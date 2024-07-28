package com.marcos.hexagonal.config;

import com.marcos.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.marcos.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.marcos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.marcos.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.marcos.hexagonal.application.ports.in.FindCustomerByIdInputPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
