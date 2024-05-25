package com.musinsa.product.domain.rdb.infrastructure.persistence

import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaCategoryRepository
import java.util.Optional

class CategoryRepositoryAdapter(private val jpaCategoryRepository: JpaCategoryRepository) : CategoryRepository {
    override fun findCategoryByName(categoryName: String): Category? {
        return jpaCategoryRepository.findCategoryByName(categoryName)
    }

    override fun findById(categoryId: Long): Optional<Category> {
        return jpaCategoryRepository.findById(categoryId)
    }
}
