package com.musinsa.product.manager.application.fasade

import com.musinsa.product.manager.application.processor.ProductAddProcessor
import com.musinsa.product.manager.application.processor.ProductRemoveProcessor
import com.musinsa.product.manager.application.processor.ProductUpdateProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductManager(
    private val productAddProcessor: ProductAddProcessor,
    private val productUpdateProcessor: ProductUpdateProcessor,
    private val productRemoveProcessor: ProductRemoveProcessor
) {
    @Transactional
    fun addProduct(brandId: Long, categoryId: Long, price: Int) {
        productAddProcessor.execute(brandId, categoryId, price)
    }

    @Transactional
    fun modifyProduct(productId: Long, price: Int, brandId: Long, categoryId: Long) {
        productUpdateProcessor.execute(productId, price, brandId, categoryId)
    }

    @Transactional
    fun removeProduct(productId: Long) {
        productRemoveProcessor.execute(productId)
    }
}