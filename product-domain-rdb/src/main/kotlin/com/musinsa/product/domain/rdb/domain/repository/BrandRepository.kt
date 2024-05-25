package com.musinsa.product.domain.rdb.domain.repository

import com.musinsa.product.domain.rdb.domain.entity.Brand
import java.util.Optional

interface BrandRepository {
    fun findByName(brandName: String): Brand?
    fun save(brand: Brand)
    fun findById(id: Long): Optional<Brand>
    fun delete(brand: Brand)
}