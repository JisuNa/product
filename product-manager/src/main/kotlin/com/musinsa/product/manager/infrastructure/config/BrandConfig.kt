package com.musinsa.product.manager.infrastructure.config

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.manager.application.processor.BrandAddProcessor
import com.musinsa.product.manager.application.processor.BrandRemoveProcessor
import com.musinsa.product.manager.application.processor.BrandUpdateProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BrandConfig {
    @Bean
    fun brandAddProcessor(brandRepository: BrandRepository) = BrandAddProcessor(brandRepository)
    @Bean
    fun brandUpdateProcessor(brandRepository: BrandRepository) = BrandUpdateProcessor(brandRepository)
    @Bean
    fun brandRemoveProcessor(brandRepository: BrandRepository) = BrandRemoveProcessor(brandRepository)
}