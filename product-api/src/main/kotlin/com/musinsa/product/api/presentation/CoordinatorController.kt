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

    @GetMapping("/category/min-price")
    fun getProductsByCategoryMinPrice(): SingleResponse<MinPriceProductResponse> {
        return SingleResponse(
            coordinatorManager.getProductsByCategoryMinPrice()
                .let { MinPriceProductResponse.of(it) }
        )
    }

    @GetMapping("/cheapest/brand")
    fun getCheapestBrandProducts(): SingleResponse<CheapestPriceBrandResponse> {
        return SingleResponse(
            coordinatorManager.getCheapestBrandProducts()
                .let { CheapestPriceBrandResponse.of(it) }
        )
    }
}
