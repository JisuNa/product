package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class ProductAddRequest(
    @field:NotNull(message = "브랜드 id를 입력해주세요.")
    val brandId: Long,
    @field:NotNull(message = "카테고리 id를 입력해주세요.")
    val categoryId: Long,
    @field:Min(1, message = "가격을 1원 이상으로 입력해주세요.")
    val price: Int
)
