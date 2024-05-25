package com.musinsa.product.domain.rdb.domain.repository

import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto

interface ProductRepository {
    fun findMinPriceProductsByCategory(): List<ProductDto>
    fun findCheapestBrand(): BrandDto?
    fun findProductsByBrandId(brandId: Long): List<ProductDto>
    fun findMinPriceProductByCategoryId(id: Long): ProductDto?
    fun findMaxPriceProductsByCategory(id: Long): ProductDto?
}