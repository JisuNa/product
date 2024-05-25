package com.musinsa.product.domain.rdb.domain.dto

data class MaxMinPriceProductDto(
    val categoryName: String,
    val maxPriceProduct: ProductDto,
    val minPriceProduct: ProductDto
)
