package com.musinsa.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductManagerApplication

fun main(args: Array<String>) {
    runApplication<ProductManagerApplication>(*args)
}
