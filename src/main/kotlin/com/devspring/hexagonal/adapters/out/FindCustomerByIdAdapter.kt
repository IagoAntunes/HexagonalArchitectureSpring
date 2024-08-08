package com.devspring.hexagonal.adapters.out

import com.devspring.hexagonal.adapters.out.repository.CustomerRepository
import com.devspring.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private  val customerRepository: CustomerRepository
) : FindCustomerByIdOutputPort{
    override fun find(id: String): Customer? {
        val customer : CustomerEntity? =  customerRepository.findById(id).getOrNull()
        return customer?.toCustomer()
    }

}