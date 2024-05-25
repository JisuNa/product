package com.musinsa.product.api.presentation.common.response

import com.musinsa.product.api.application.common.GlobalResponseType

class ErrorResponse(
    code: GlobalResponseType,
    message: String
) : BaseResponse(code, message)
