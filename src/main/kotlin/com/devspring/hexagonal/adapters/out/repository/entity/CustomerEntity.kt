package com.devspring.hexagonal.adapters.out.repository.entity

import com.devspring.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "customers")
data class CustomerEntity(
    @MongoId
    val id:String? = null,
    val name:String,
    val address:AddressEntity? = null,
    val cpf: String,
    val isValidCpf: Boolean = false,
){

    constructor(customer:Customer) : this(
        id = customer.id,
        name = customer.name,
        address = AddressEntity(customer.address!!),
        cpf = customer.cpf,
        isValidCpf = customer.isValidCpf
    )

    fun toCustomer() : Customer{
        return Customer(
            id = this.id,
            name = this.name,
            address = this.address?.toAddress(),
            cpf = this.cpf,
            isValidCpf = this.isValidCpf
        )
    }


}
