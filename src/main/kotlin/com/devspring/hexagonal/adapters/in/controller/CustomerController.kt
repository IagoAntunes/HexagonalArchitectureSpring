package com.devspring.hexagonal.adapters.`in`.controller

import com.devspring.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.devspring.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.devspring.hexagonal.application.core.domain.Customer
import com.devspring.hexagonal.application.ports.`in`.FindCustomerByInputPort
import com.devspring.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByInputPort: FindCustomerByInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest){
        with(customerRequest){
            val customer = Customer(
                name = name,
                cpf = cpf,
            )
            insertCustomerInputPort.insert(customer,zipCode)
        }

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id:String) : CustomerResponse{
        val customer = findCustomerByInputPort.find(id)
        return CustomerResponse(customer)
    }

}