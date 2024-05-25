package com.musinsa.product.api.application.processor

import com.musinsa.product.api.application.exception.NotFoundBrandException
import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository

class CheapestBrandProductsProcessor(
    private val productRepository: ProductRepository
) {
    fun execute(): BrandDto {
        val cheapestBrandDto = productRepository.findCheapestBrand() ?: throw NotFoundBrandException()
        val minPriceProductDtos = productRepository.findProductsByBrandId(cheapestBrandDto.brandId)

        return cheapestBrandDto.apply { products = minPriceProductDtos }
    }
}
