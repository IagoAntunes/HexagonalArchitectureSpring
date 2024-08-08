package com.devspring.hexagonal.application.ports.`in`

import com.devspring.hexagonal.application.core.domain.Customer
import org.springframework.stereotype.Service

@Service
interface InsertCustomerInputPort {

    fun insert(customer:Customer,zipCode:String)

}