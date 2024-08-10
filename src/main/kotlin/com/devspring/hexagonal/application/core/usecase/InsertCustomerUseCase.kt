package com.devspring.hexagonal.application.core.usecase

import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.devspring.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.devspring.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.devspring.hexagonal.application.ports.out.SendCpfForValidationOutputPort


class InsertCustomerUseCase(
    // Busca o endereço pelo CEP
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    // Insere o cliente no banco de dados
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : InsertCustomerInputPort{

    override fun insert(customer: Customer, zipCode:String) : Unit{
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }

}