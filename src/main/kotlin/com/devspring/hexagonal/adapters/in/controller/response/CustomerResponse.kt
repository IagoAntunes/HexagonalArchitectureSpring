package com.devspring.hexagonal.adapters.`in`.controller.response

import com.devspring.hexagonal.application.core.domain.Customer

data class CustomerResponse(
    val id:String,
    val name: String,
    val address: AddressResponse,
    val cpf: String,
    val isValidCpf: Boolean
){

    constructor(customer:Customer) : this(
        id = customer.id!!,
        name = customer.name,
        address = AddressResponse(customer.address!!),
        cpf = customer.cpf,
        isValidCpf = customer.isValidCpf
    )

}