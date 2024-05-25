package com.musinsa.product.domain.rdb.infrastructure.persistence.jpa

import com.musinsa.product.domain.rdb.domain.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface JpaBrandRepository : JpaRepository<Brand, Long> {
    fun findByName(brandName: String): Brand?
}