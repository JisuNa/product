package com.musinsa.product.manager.presentation.common.response

import com.musinsa.product.manager.application.common.GlobalResponseType

open class BaseResponse(
    val code: GlobalResponseType,
    val message: String = code.defaultMessage
)
