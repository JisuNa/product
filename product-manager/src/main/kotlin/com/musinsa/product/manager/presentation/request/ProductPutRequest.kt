package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.NotNull

data class ProductPutRequest(
    @field:NotNull(message = "상품 id를 입력해주세요.")
    val productId: Long,
    @field:NotNull(message = "가격을 입력해주세요.")
    val price: Int,
    @field:NotNull(message = "브랜드 id를 입력해주세요.")
    val brandId: Long,
    @field:NotNull(message = "카테고리 id를 입력해주세요.")
    val categoryId: Long
)
