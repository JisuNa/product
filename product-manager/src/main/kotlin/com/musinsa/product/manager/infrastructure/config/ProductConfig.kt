package com.musinsa.product.manager.infrastructure.config

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import com.musinsa.product.manager.application.processor.ProductAddProcessor
import com.musinsa.product.manager.application.processor.ProductRemoveProcessor
import com.musinsa.product.manager.application.processor.ProductUpdateProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductConfig {

    @Bean
    fun productAddProcessor(
        productRepository: ProductRepository,
        brandRepository: BrandRepository,
        categoryRepository: CategoryRepository
    ) = ProductAddProcessor(productRepository, brandRepository, categoryRepository)

    @Bean
    fun productUpdateProcessor(
        productRepository: ProductRepository,
        brandRepository: BrandRepository,
        categoryRepository: CategoryRepository
    ) = ProductUpdateProcessor(productRepository, brandRepository, categoryRepository)

    @Bean
    fun productRemoveProcessor(productRepository: ProductRepository) = ProductRemoveProcessor(productRepository)
}