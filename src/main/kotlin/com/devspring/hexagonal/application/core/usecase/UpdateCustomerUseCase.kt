package com.devspring.hexagonal.application.core.usecase

import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.ports.`in`.FindCustomerByInputPort
import com.devspring.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.devspring.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.devspring.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
) : UpdateCustomerInputPort {

    override fun update(customer:Customer,zipCode:String){
        if(customer.id == null){
            throw IllegalArgumentException("Customer cannot be null")
        }
        var foundCustomer = findCustomerByIdInputPort.find(customer.id)

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
        }
    }

}