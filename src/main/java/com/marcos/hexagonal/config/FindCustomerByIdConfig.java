package com.marcos.hexagonal.config;

import com.marcos.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.marcos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.marcos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdInputPort findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
