package com.musinsa.product.domain.rdb.domain.repository

import com.musinsa.product.domain.rdb.domain.entity.Brand

interface BrandRepository {
    fun findByName(brandName: String): Brand?
    fun save(brandName: String)
}