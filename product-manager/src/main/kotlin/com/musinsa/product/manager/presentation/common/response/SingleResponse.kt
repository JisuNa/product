package com.musinsa.product.manager.presentation.common.response

import com.musinsa.product.manager.application.common.GlobalResponseType

class SingleResponse<T>(
    val data: T,
    code: GlobalResponseType = GlobalResponseType.OK
) : BaseResponse(code)
