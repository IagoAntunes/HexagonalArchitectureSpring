package com.devspring.hexagonal.config

import com.devspring.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.devspring.hexagonal.adapters.out.InsertCustomerAdapter
import com.devspring.hexagonal.application.core.usecase.InsertCustomerUseCase
import com.devspring.hexagonal.application.ports.`in`.InsertCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerOutputPort: InsertCustomerAdapter
    ) : InsertCustomerInputPort{
        return InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerOutputPort)
    }

}