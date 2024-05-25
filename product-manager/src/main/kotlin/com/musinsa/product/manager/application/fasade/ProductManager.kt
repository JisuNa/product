package com.musinsa.product.manager.application.fasade

import com.musinsa.product.manager.application.processor.BrandAddProcessor
import com.musinsa.product.manager.application.processor.BrandRemoveProcessor
import com.musinsa.product.manager.application.processor.BrandUpdateProcessor
import com.musinsa.product.manager.application.processor.ProductAddProcessor
import com.musinsa.product.manager.application.processor.ProductRemoveProcessor
import com.musinsa.product.manager.application.processor.ProductUpdateProcessor
import com.musinsa.product.manager.presentation.request.BrandAddRequest
import org.springframework.stereotype.Service

@Service
class ProductManager(
    private val productAddProcessor: ProductAddProcessor,
    private val productUpdateProcessor: ProductUpdateProcessor,
    private val productRemoveProcessor: ProductRemoveProcessor
) {
    fun addProduct() {
        productAddProcessor.execute()
    }

    fun updateProduct() {
        productUpdateProcessor.execute()
    }

    fun removeProduct() {
        productRemoveProcessor.execute()
    }
}