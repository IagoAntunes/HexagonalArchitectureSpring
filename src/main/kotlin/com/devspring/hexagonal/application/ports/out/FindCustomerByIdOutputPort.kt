package com.devspring.hexagonal.application.ports.out

import com.devspring.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id:String) : Customer?

}