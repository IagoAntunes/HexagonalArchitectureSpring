package com.devspring.hexagonal.adapters.out.repository.entity

import com.devspring.hexagonal.application.core.domain.Address
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "address")
data class AddressEntity(
    val street:String,
    val city:String,
    val state:String,
) {
    constructor(address: Address) : this(
        street = address.street,
        city = address.city,
        state = address.state
    )

    fun toAddress() : Address{
        return Address(
            street = this.street,
            city = this.city,
            state = this.state
        )
    }
}
