package com.musinsa.product.manager.presentation.common.response

import com.musinsa.product.manager.application.common.GlobalResponseType

class NoDataResponse : BaseResponse {
    constructor() : super(GlobalResponseType.OK)
    constructor(message: String) : super(GlobalResponseType.OK, message)
}
