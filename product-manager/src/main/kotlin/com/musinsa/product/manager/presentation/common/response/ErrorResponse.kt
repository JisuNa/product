package com.musinsa.product.manager.presentation.common.response

import com.musinsa.product.manager.application.common.GlobalResponseType

class ErrorResponse(
    code: GlobalResponseType,
    message: String
) : BaseResponse(code, message)