package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.NotNull

data class ProductRemoveRequest(
    @field:NotNull(message = "상품 id를 입력해주세요.")
    val productId: Long
)
