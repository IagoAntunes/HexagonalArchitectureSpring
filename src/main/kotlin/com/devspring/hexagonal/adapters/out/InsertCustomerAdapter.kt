package com.devspring.hexagonal.adapters.out

import com.devspring.hexagonal.adapters.out.repository.CustomerRepository
import com.devspring.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
) : InsertCustomerOutputPort {
    override fun insert(customer: Customer): Customer {
        customerRepository.save(CustomerEntity(customer))
        return customer
    }
}