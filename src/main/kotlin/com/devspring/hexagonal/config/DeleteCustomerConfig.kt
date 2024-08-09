package com.devspring.hexagonal.config

import com.devspring.hexagonal.application.core.usecase.DeleteCustomerUseCase
import com.devspring.hexagonal.application.ports.`in`.DeleteCustomerInputPort
import com.devspring.hexagonal.application.ports.out.DeleteCustomerOutputPort
import com.devspring.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        deleteCustomerOutputPort: DeleteCustomerOutputPort,
        findCustomerByIdOutputPort: FindCustomerByIdOutputPort
    ) : DeleteCustomerInputPort{
        return DeleteCustomerUseCase(
            deleteCustomerOutputPort,
            findCustomerByIdOutputPort
        )
    }

}