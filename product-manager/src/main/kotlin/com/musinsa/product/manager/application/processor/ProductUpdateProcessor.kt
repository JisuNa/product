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
import com.musinsa.product.manager.application.exception.NotFoundProductException

class ProductUpdateProcessor(
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository,
    private val categoryRepository: CategoryRepository
) {
    fun execute(productId: Long, price: Int, brandId: Long, categoryId: Long) {
        val product = getProduct(productId)
        val brand = getBrand(brandId)
        val category = getCategory(categoryId)

        checkDuplicateProduct(brand, category, price)

        updateProduct(product, price, brandId, categoryId)
    }

    private fun getProduct(productId: Long): Product {
        return productRepository.findById(productId).orElseThrow { NotFoundProductException() }
    }

    private fun getBrand(brandId: Long): Brand {
        return brandRepository.findById(brandId).orElseThrow { NotFoundBrandException() }
    }

    private fun getCategory(categoryId: Long): Category {
        return categoryRepository.findById(categoryId).orElseThrow { NotFoundCategoryException() }
    }

    private fun checkDuplicateProduct(brand: Brand, category: Category, price: Int) {
        productRepository.findByBrandAndCategory(brand, category)?.run {
            if (this.price == price) {
                throw DuplicateProductException()
            }
        }
    }

    private fun updateProduct(product: Product, price: Int, brandId: Long, categoryId: Long) {
        product.apply { update(brandId, categoryId, price) }
    }
}
