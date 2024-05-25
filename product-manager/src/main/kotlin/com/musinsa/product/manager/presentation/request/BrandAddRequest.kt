package com.musinsa.product.manager.presentation.request

import jakarta.validation.constraints.NotNull

data class BrandAddRequest(
    @NotNull
    val name: String
)
