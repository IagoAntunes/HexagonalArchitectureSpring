package com.devspring.hexagonal.application.core.usecase

import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.devspring.hexagonal.application.ports.`in`.FindCustomerByInputPort
import com.devspring.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) : FindCustomerByInputPort{
    override fun find(id:String) : Customer{
        return findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")
    }

}