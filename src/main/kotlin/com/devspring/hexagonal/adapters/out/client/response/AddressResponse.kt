package com.devspring.hexagonal.adapters.out.client.response

import com.devspring.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street:String,
    val city:String,
    val state:String
){

    fun toAddress() : Address{
        return Address(
            street = street,
            city = city,
            state = state
        )
    }


}
