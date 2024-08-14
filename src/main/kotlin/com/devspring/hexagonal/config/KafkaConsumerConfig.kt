package com.devspring.hexagonal.config

import com.devspring.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka// Habilitar uso de anotações Kafka
@Configuration
class KafkaConsumerConfig {

    private val configProps = mapOf(
        BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
        GROUP_ID_CONFIG to "group_id",
        KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
        AUTO_OFFSET_RESET_CONFIG to "earliest"
    )

    @Bean
    fun consumerFactory() : ConsumerFactory<String,CustomerMessage> {
        return DefaultKafkaConsumerFactory(configProps, StringDeserializer(),JsonDeserializer(CustomerMessage::class.java)
        )
    }

    @Bean
    fun kafkaListenerContainerFactory() : ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> {
        val factory = ConcurrentKafkaListenerContainerFactory<String,CustomerMessage>()
        factory.consumerFactory = consumerFactory()
        return factory
    }

}