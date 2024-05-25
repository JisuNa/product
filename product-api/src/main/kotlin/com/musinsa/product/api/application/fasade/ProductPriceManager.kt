package com.musinsa.product.api.application.fasade

import com.musinsa.product.api.application.processor.MaxMinPriceProductGetProcessor
import com.musinsa.product.api.application.vo.MaxMinPriceProductVo
import org.springframework.stereotype.Service

@Service
class ProductPriceManager(
    private val minMaxPriceProductGetProcessor: MaxMinPriceProductGetProcessor
) {
    fun getMaxMinPriceProducts(categoryName: String): MaxMinPriceProductVo {
        return minMaxPriceProductGetProcessor.execute(categoryName)
    }
}