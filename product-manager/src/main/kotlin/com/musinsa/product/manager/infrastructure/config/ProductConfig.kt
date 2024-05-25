package com.musinsa.product.manager.infrastructure.config

import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import com.musinsa.product.manager.application.processor.ProductAddProcessor
import com.musinsa.product.manager.application.processor.ProductRemoveProcessor
import com.musinsa.product.manager.application.processor.ProductUpdateProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductConfig {

    @Bean
    fun productAddProcessor(productRepository: ProductRepository) = ProductAddProcessor(productRepository)
    @Bean
    fun productUpdateProcessor() = ProductUpdateProcessor()
    @Bean
    fun productRemoveProcessor() = ProductRemoveProcessor()
}