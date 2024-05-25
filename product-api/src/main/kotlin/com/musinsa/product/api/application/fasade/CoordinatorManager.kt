package com.musinsa.product.api.application.fasade

import com.musinsa.product.api.application.processor.CheapestBrandProductsProcessor
import com.musinsa.product.api.application.processor.MinPriceProductsGetByCategoryProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CoordinatorManager(
    private val minPriceProductsGetByCategoryProcessor: MinPriceProductsGetByCategoryProcessor,
    private val cheapestBrandProductsProcessor: CheapestBrandProductsProcessor
) {
    @Transactional(readOnly = true)
    fun getProductsByCategoryMinPrice() = minPriceProductsGetByCategoryProcessor.execute()

    @Transactional(readOnly = true)
    fun getCheapestBrandProducts() = cheapestBrandProductsProcessor.execute()

}
