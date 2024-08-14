package com.devspring.hexagonal.adapters.`in`.consumer

import com.devspring.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.devspring.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "group_id")
    fun receive(customerMessage: CustomerMessage) {
        updateCustomerInputPort.update(customerMessage.toCustomer(),customerMessage.zipCode)
    }


}