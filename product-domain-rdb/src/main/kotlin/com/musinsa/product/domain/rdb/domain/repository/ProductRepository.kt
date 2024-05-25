package com.musinsa.product.domain.rdb.domain.repository

import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto
import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.domain.rdb.domain.entity.Product
import java.util.Optional

interface ProductRepository {
    fun findMinPriceProductsByCategory(): List<ProductDto>
    fun findCheapestBrand(): BrandDto?
    fun findProductsByBrandId(brandId: Long): List<ProductDto>
    fun findMinPriceProductByCategoryId(id: Long): ProductDto?
    fun findMaxPriceProductsByCategory(id: Long): ProductDto?
    fun save(product: Product)
    fun findById(productId: Long): Optional<Product>
    fun findByBrandAndCategory(brand: Brand, category: Category): Product?
    fun delete(product: Product)
}
