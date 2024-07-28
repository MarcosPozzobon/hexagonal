package com.marcos.hexagonal.config;

import com.marcos.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.marcos.hexagonal.adapters.out.InsertCustomerAdapter;
import com.marcos.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.marcos.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }

}
