package com.devspring.hexagonal.adapters.`in`.controller.response

import com.devspring.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street:String,
    val city: String,
    val state: String,
){
    constructor(address: Address) : this(
        street = address.street,
        city = address.city,
        state = address.state
    )

}
