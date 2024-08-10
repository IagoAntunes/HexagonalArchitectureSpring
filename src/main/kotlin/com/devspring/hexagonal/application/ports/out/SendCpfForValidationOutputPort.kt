package com.devspring.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf:String)

}