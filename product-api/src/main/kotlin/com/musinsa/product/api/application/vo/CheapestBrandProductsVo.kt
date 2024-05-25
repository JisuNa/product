package com.musinsa.product.api.application.vo

data class CheapestBrandProducts(
    val brandName: String,
    val category: List<BrandProduct>,
) {
    val totalPrice = category.sumOf { it.price }
}

