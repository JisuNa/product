package com.musinsa.product.domain.rdb.domain.dto

import com.querydsl.core.annotations.QueryProjection

data class ProductDto @QueryProjection constructor(
    val brandId: Long,
    val brandName: String,
    val categoryId: Long,
    val categoryName: String,
    val price: Int
)
