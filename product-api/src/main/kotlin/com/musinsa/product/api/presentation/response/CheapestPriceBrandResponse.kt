package com.musinsa.product.api.presentation.response

import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto

data class CheapestPriceBrandResponse(
    val cheapest: CheapestPriceBrand
) {
    companion object Factory {
        fun of(dto: BrandDto): CheapestPriceBrandResponse {
            return CheapestPriceBrandResponse(
                CheapestPriceBrand.of(dto.brandName, dto.products, dto.totalPrice)
            )
        }
    }
}

data class CheapestPriceBrand(
    val brand: String,
    val products: List<Product>,
    val totalPrice: Int
) {
    companion object Factory {
        fun of(brand: String, productDots: List<ProductDto>, totalPrice: Int): CheapestPriceBrand {
            return CheapestPriceBrand(brand, productDots.map { Product.of(it) }, totalPrice)
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
