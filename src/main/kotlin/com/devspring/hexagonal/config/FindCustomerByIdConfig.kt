package com.devspring.hexagonal.config

import com.devspring.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.devspring.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.devspring.hexagonal.application.ports.`in`.FindCustomerByInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter) : FindCustomerByInputPort {
        return FindCustomerByIdUseCase(findCustomerByIdAdapter)
    }
}