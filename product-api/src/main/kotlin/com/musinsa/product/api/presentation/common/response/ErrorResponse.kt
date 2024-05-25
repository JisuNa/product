package com.musinsa.product.api.presentation.common.response

import com.musinsa.product.common.type.GlobalResponseType

class ErrorResponse(
    code: GlobalResponseType,
    message: String
) : BaseResponse(code, message)