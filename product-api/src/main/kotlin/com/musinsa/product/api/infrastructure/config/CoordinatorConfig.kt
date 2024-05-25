package com.musinsa.product.api.infrastructure.config

import com.musinsa.product.api.application.processor.CheapestBrandProductsProcessor
import com.musinsa.product.api.application.processor.MinPriceProductsGetByCategoryProcessor
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoordinatorConfig {

    @Bean
    fun brandProductsGetByMinTotalPriceProcessor(productRepository: ProductRepository) =
        CheapestBrandProductsProcessor(productRepository)

    @Bean
    fun minPriceProductsGetByCategoryProcessor(productRepository: ProductRepository) =
        MinPriceProductsGetByCategoryProcessor(productRepository)
}