package com.musinsa.product.api.application.processor

import com.musinsa.product.api.application.exception.NotFoundCategoryException
import com.musinsa.product.api.application.exception.NotFoundProductException
import com.musinsa.product.api.application.vo.MaxMinPriceProductVo
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository

class MaxMinPriceProductGetProcessor(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) {
    fun execute(categoryName: String): MaxMinPriceProductVo {
        val category = categoryRepository.findCategoryByName(categoryName) ?: throw NotFoundCategoryException()

        val minPriceProduct = productRepository.findMinPriceProductByCategoryId(category.id)
            ?: throw NotFoundProductException()
        val maxMinPriceProducts = productRepository.findMaxPriceProductsByCategory(category.id)
            ?: throw NotFoundProductException()

        return MaxMinPriceProductVo.of(category.name, minPriceProduct, maxMinPriceProducts)
    }
}
