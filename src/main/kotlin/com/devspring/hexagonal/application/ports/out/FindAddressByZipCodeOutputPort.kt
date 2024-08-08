package com.devspring.hexagonal.application.ports.out

import com.devspring.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode:String): Address

}