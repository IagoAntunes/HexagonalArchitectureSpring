package com.devspring.hexagonal.adapters.out

import com.devspring.hexagonal.adapters.out.repository.CustomerRepository
import com.devspring.hexagonal.application.ports.out.DeleteCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerAdapter(
    private val customerRepository: CustomerRepository
) : DeleteCustomerOutputPort{

    override fun delete(id:String){
        customerRepository.deleteById(id)
    }

}