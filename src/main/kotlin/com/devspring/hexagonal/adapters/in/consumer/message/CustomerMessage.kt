package com.devspring.hexagonal.adapters.`in`.consumer.message

import com.devspring.hexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id:String,
    val name:String,
    val zipCode:String,
    val cpf:String,
    val isValidCpf: Boolean

){

    fun toCustomer() : Customer{
        return Customer(id = id,name = name,cpf= cpf, isValidCpf = isValidCpf)
    }
}
