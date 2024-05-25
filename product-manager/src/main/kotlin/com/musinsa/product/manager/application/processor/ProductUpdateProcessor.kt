package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.manager.application.exception.NotFoundProductException
import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import com.musinsa.product.manager.application.exception.DuplicateProductException
import com.musinsa.product.manager.application.exception.NotFoundBrandException
import com.musinsa.product.manager.application.exception.NotFoundCategoryException

class ProductUpdateProcessor(
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository,
    private val categoryRepository: CategoryRepository
) {
    fun execute(productId: Long, price: Int, brandId: Long, categoryId: Long) {
        val brand = findBrandById(brandId)
        val category = findCategoryById(categoryId)

        checkDuplicateProduct(brand, category)

        updateProduct(productId, price, brandId, categoryId)
    }

    private fun findBrandById(brandId: Long): Brand {
        return brandRepository.findById(brandId).orElseThrow { NotFoundBrandException() }
    }

    private fun findCategoryById(categoryId: Long): Category {
        return categoryRepository.findById(categoryId).orElseThrow { NotFoundCategoryException() }
    }

    private fun checkDuplicateProduct(brand: Brand, category: Category) {
        productRepository.findByBrandAndCategory(brand, category)?.run { throw DuplicateProductException() }
    }

    private fun updateProduct(productId: Long, price: Int, brandId: Long, categoryId: Long) {
        productRepository.findById(productId).orElseThrow { NotFoundProductException() }
            .apply { update(brandId, categoryId, price) }
    }
}
