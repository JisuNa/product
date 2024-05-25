package com.musinsa.product.api.application.vo

import com.musinsa.product.domain.rdb.domain.dto.ProductDto

data class MaxMinPriceProductVo(
    val categoryName: String,
    val minPriceProduct: List<ProductVo>,
    val maxPriceProduct: List<ProductVo>
) {
    companion object Factory {
        fun of(categoryName: String, minPriceProduct: ProductDto, maxPriceProduct: ProductDto): MaxMinPriceProductVo {
            return MaxMinPriceProductVo(
                categoryName = categoryName,
                minPriceProduct = listOf(ProductVo.of(minPriceProduct)),
                maxPriceProduct = listOf(ProductVo.of(maxPriceProduct))
            )
        }
    }
}

data class ProductVo(
    val brandName: String,
    val price: Int
) {
    companion object Factory {
        fun of(dto: ProductDto): ProductVo {
            return ProductVo(dto.brandName, dto.price)
        }
    }
}
