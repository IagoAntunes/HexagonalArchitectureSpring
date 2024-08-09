package com.devspring.hexagonal.application.core.usecase

import com.devspring.hexagonal.application.ports.`in`.DeleteCustomerInputPort
import com.devspring.hexagonal.application.ports.out.DeleteCustomerOutputPort
import com.devspring.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class DeleteCustomerUseCase(
    private val deleteCustomerOutputPort: DeleteCustomerOutputPort,
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) : DeleteCustomerInputPort {

    override fun delete(id:String){
        findCustomerByIdOutputPort.find(id)
        deleteCustomerOutputPort.delete(id)
    }

}