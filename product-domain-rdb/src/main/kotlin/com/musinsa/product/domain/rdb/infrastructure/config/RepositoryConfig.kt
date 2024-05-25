package com.musinsa.product.domain.rdb.infrastructure.config

import com.musinsa.product.domain.rdb.infrastructure.persistence.BrandRepositoryAdapter
import com.musinsa.product.domain.rdb.infrastructure.persistence.CategoryRepositoryAdapter
import com.musinsa.product.domain.rdb.infrastructure.persistence.ProductRepositoryAdapter
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaBrandRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaCategoryRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepositoryConfig {

    @Bean
    fun brandRepositoryAdapter(jpaBrandRepository: JpaBrandRepository) = BrandRepositoryAdapter(jpaBrandRepository)

    @Bean
    fun productRepositoryAdapter(jpaProductRepository: JpaProductRepository) =
        ProductRepositoryAdapter(jpaProductRepository)

    @Bean
    fun categoryRepositoryAdapter(jpaCategoryRepository: JpaCategoryRepository) =
        CategoryRepositoryAdapter(jpaCategoryRepository)
}
