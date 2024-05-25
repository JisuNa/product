package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.domain.rdb.domain.entity.Product
import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import com.musinsa.product.manager.application.exception.DuplicateProductException
import com.musinsa.product.manager.application.exception.NotFoundBrandException
import com.musinsa.product.manager.application.exception.NotFoundCategoryException

class ProductAddProcessor(
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository,
    private val categoryRepository: CategoryRepository
) {
    fun execute(brandId: Long, categoryId: Long, price: Int) {
        val brand = findBrandById(brandId)
        val category = findCategoryById(categoryId)

        checkDuplicateProduct(brand, category)

        productRepository.save(Product(price, brand, category))
    }

    private fun findBrandById(brandId: Long): Brand {
        return brandRepository.findById(brandId).orElseThrow { NotFoundBrandException() }
    }

    private fun findCategoryById(categoryId: Long): Category {
        return categoryRepository.findById(categoryId).orElseThrow { NotFoundCategoryException() }
    }

    private fun checkDuplicateProduct(brand: Brand, category: Category) {
        productRepository.findByBrandAndCategory(brand, category)?.let { throw DuplicateProductException() }
    }
}
