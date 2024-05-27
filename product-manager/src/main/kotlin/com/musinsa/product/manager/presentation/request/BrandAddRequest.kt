package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.NotNull

data class BrandAddRequest(
    @field:NotNull(message = "브랜드명을 입력해주세요.")
    val brandName: String
)
