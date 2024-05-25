package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Product
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import com.musinsa.product.manager.application.exception.NotFoundProductException

class ProductRemoveProcessor(private val productRepository: ProductRepository) {
    fun execute(productId: Long) {
        val product = findProductById(productId)
        deleteProduct(product)
    }

    private fun findProductById(productId: Long): Product {
        return productRepository.findById(productId).orElseThrow { NotFoundProductException() }
    }

    private fun deleteProduct(product: Product) {
        productRepository.delete(product)
    }
}