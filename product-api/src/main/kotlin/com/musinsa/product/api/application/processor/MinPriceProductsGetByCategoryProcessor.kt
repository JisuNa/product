package com.musinsa.product.api.application.processor

import com.musinsa.product.domain.rdb.domain.dto.ProductDto
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository

class MinPriceProductsGetByCategoryProcessor(
    private val productRepository: ProductRepository
) {
    fun execute(): List<ProductDto> {
        return productRepository.findMinPriceProductsByCategory().distinctBy { it.categoryId }
    }
}