package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.NotNull

data class BrandRemoveRequest(
    @field:NotNull(message = "브랜드 id를 입력해주세요.")
    val id: Long
)
