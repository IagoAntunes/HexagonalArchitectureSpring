package com.devspring.hexagonal.application.ports.out

interface DeleteCustomerOutputPort {

    fun delete(id:String)

}