package com.musinsa.product.domain.rdb.infrastructure.persistence.jpa

import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto

interface JpaProductRepositoryCustom {
    fun findMinPriceProductsByCategory(): List<ProductDto>
    fun findCheapestBrand(): BrandDto?
    fun findProductsByBrandId(brandId: Long): List<ProductDto>
    fun findMinPriceProductByCategory(categoryId: Long): ProductDto?
    fun findMaxPriceProductByCategory(categoryId: Long): ProductDto?
}
