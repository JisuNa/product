package com.musinsa.product.api.presentation

import com.musinsa.product.api.application.fasade.ProductPriceManager
import com.musinsa.product.api.application.vo.MaxMinPriceProductVo
import com.musinsa.product.api.presentation.common.response.SingleResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product/price")
class ProductPriceController(private val productPriceManager: ProductPriceManager) {

    @GetMapping("/max-min", name = "카테고리 최고가 최저가 상품 조회")
    fun getMaxMinPriceProducts(@RequestParam categoryName: String): SingleResponse<MaxMinPriceProductVo> {
        return SingleResponse(productPriceManager.getMaxMinPriceProducts(categoryName))
    }
}
