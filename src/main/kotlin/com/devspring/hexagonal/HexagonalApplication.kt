package com.devspring.hexagonal

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration(FeignAutoConfiguration::class)
class HexagonalApplication

fun main(args: Array<String>) {
	runApplication<HexagonalApplication>(*args)
}
