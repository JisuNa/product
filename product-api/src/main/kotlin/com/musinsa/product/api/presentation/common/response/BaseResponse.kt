package com.musinsa.product.api.presentation.common.response

import com.musinsa.product.api.application.common.GlobalResponseType

open class BaseResponse(
    val code: GlobalResponseType,
    val message: String = code.defaultMessage
)