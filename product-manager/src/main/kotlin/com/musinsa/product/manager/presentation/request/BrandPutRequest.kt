package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.NotNull

data class BrandPutRequest(
    @field:NotNull(message = "브랜드 id를 입력해주세요.")
    val brandId: Long,
    @field:NotNull(message = "브랜드명을 입력해주세요.")
    val brandName: String
)
