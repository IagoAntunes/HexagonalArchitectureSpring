package com.devspring.hexagonal.adapters.out

import com.devspring.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.devspring.hexagonal.application.core.domain.Address
import com.devspring.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
) : FindAddressByZipCodeOutputPort{


    override fun find(zipCode: String): Address {
        val addressResponse = findAddressByZipCodeClient.find(zipCode)
        return addressResponse.toAddress()
    }
}