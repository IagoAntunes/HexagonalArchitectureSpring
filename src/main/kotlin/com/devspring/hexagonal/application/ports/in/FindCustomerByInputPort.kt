package com.devspring.hexagonal.application.ports.`in`

import com.devspring.hexagonal.application.core.domain.Customer

interface FindCustomerByInputPort {

    fun find(id:String): Customer

}