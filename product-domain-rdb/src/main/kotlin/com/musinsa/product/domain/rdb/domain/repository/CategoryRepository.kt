package com.musinsa.product.domain.rdb.domain.repository

import com.musinsa.product.domain.rdb.domain.entity.Category

interface CategoryRepository {
    fun findCategoryByName(categoryName: String): Category?
}