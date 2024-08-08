package com.devspring.hexagonal.application.ports.`in`

import com.devspring.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {
    fun update(customer: Customer, zipCode:String)
}