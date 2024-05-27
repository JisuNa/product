package com.musinsa.product.domain.rdb.domain.dto

import com.querydsl.core.annotations.QueryProjection

data class BrandDto @QueryProjection constructor(
    val brandId: Long,
    val brandName: String
) {
    var products: List<ProductDto> = listOf()
    var totalPrice: Int = 0
}
