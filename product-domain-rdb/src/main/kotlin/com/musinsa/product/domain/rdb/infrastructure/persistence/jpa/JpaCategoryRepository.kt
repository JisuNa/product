package com.musinsa.product.domain.rdb.infrastructure.persistence.jpa

import com.musinsa.product.domain.rdb.domain.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCategoryRepository : JpaRepository<Category, Long> {
    fun findCategoryByName(categoryName: String): Category?
}