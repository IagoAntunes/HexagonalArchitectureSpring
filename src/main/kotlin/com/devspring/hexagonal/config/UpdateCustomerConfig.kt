package com.devspring.hexagonal.config

import com.devspring.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.devspring.hexagonal.adapters.out.UpdateCustomerAdapter
import com.devspring.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.devspring.hexagonal.application.core.usecase.UpdateCustomerUseCase
import com.devspring.hexagonal.application.ports.`in`.FindCustomerByInputPort
import com.devspring.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.devspring.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {


    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByInputPort,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
    ) : UpdateCustomerInputPort {
        return UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter,
            sendCpfForValidationOutputPort
        )
    }

}