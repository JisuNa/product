package com.musinsa.product.api.presentation.common.response

import com.musinsa.product.api.application.common.GlobalResponseType

class SingleResponse<T>(
    val data: T,
    code: GlobalResponseType = GlobalResponseType.OK
) : BaseResponse(code)
