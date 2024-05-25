package com.musinsa.product.api.presentation.response

import com.musinsa.product.domain.rdb.domain.dto.ProductDto

data class MinPriceProductResponse(
    val products: List<MinPriceProduct>
) {
    val totalPrice = products.sumOf { it.price }

    companion object Factory {
        fun of(productDtos: List<ProductDto>): MinPriceProductResponse {
            return MinPriceProductResponse(productDtos.map { MinPriceProduct.of(it) })
        }
    }
}

data class MinPriceProduct(
    val categoryName: String,
    val brandName: String,
    val price: Int
) {
    companion object Factory {
        fun of(product: ProductDto): MinPriceProduct {
            return MinPriceProduct(
                categoryName = product.categoryName,
                brandName = product.brandName,
                price = product.price
            )
        }
    }
}
