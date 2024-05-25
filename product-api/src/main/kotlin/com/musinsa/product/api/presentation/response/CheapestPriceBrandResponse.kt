package com.musinsa.product.api.presentation.response

import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto

data class CheapestPriceBrandResponse(
    val cheapest: CheapestPriceBrand
) {
    companion object Factory {
        fun of(dto: BrandDto): CheapestPriceBrandResponse {
            return CheapestPriceBrandResponse(
                CheapestPriceBrand.of(dto.brandName, dto.products)
            )
        }
    }
}

data class CheapestPriceBrand(
    val brand: String,
    val product: List<Product>,
    val totalPrice: Int
) {
    companion object Factory {
        fun of(brand: String, productDots: List<ProductDto>): CheapestPriceBrand {
            return CheapestPriceBrand(
                brand,
                productDots.map { Product.of(it) },
                productDots.sumOf { it.price }
            )
        }
    }
}

data class Product(
    val categoryName: String,
    val price: Int
) {
    companion object Factory {
        fun of(dto: ProductDto): Product {
            return Product(dto.categoryName, dto.price)
        }
    }
}
