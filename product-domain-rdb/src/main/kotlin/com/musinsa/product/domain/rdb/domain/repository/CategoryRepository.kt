package com.musinsa.product.domain.rdb.domain.repository

import com.musinsa.product.domain.rdb.domain.entity.Category
import java.util.Optional

interface CategoryRepository {
    fun findCategoryByName(categoryName: String): Category?
    fun findById(categoryId: Long): Optional<Category>
}