package com.devspring.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotBlank(message = "CPF is required")
    val cpf: String,
    @field:NotBlank(message = "Street is required")
    val zipCode:String
)
