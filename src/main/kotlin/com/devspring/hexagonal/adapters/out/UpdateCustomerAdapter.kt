package com.devspring.hexagonal.adapters.out

import com.devspring.hexagonal.adapters.out.repository.CustomerRepository
import com.devspring.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
) : UpdateCustomerOutputPort{
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}