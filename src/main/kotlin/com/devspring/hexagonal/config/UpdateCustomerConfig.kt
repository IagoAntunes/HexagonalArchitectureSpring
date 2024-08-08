package com.devspring.hexagonal.config

import com.devspring.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.devspring.hexagonal.adapters.out.UpdateCustomerAdapter
import com.devspring.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.devspring.hexagonal.application.core.usecase.UpdateCustomerUseCase
import com.devspring.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {


    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
    ) : UpdateCustomerInputPort {
        return UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter
        )
    }

}