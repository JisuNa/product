package com.musinsa.product.api.infrastructure.config

import com.musinsa.product.api.application.processor.MaxMinPriceProductGetProcessor
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductPriceConfig {

    @Bean
    fun minMaxPriceProductsGetProcessor(
        categoryRepository: CategoryRepository,
        productRepository: ProductRepository
    ) =
        MaxMinPriceProductGetProcessor(categoryRepository, productRepository)
}