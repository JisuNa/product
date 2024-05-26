package com.musinsa.product.api.presentation

import com.musinsa.product.api.application.fasade.CoordinatorManager
import com.musinsa.product.api.presentation.common.response.SingleResponse
import com.musinsa.product.api.presentation.response.CheapestPriceBrandResponse
import com.musinsa.product.api.presentation.response.MinPriceProductResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product/coordinator")
class CoordinatorController(private val coordinatorManager: CoordinatorManager) {

    @GetMapping("/category/min-price", name = "카테고리 별 최저가 상품 조회")
    fun getProductsByCategoryMinPrice(): SingleResponse<MinPriceProductResponse> {
        return SingleResponse(
            coordinatorManager.getProductsByCategoryMinPrice()
                .let { MinPriceProductResponse.of(it) }
        )
    }

    @GetMapping("/cheapest/brand", name = "단일 브랜드 총액 최저가 상품 조회")
    fun getCheapestBrandProducts(): SingleResponse<CheapestPriceBrandResponse> {
        return SingleResponse(
            coordinatorManager.getCheapestBrandProducts()
                .let { CheapestPriceBrandResponse.of(it) }
        )
    }
}
