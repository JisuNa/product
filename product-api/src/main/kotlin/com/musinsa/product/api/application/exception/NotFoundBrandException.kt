package com.musinsa.product.api.application.exception

import com.musinsa.product.api.application.common.GlobalResponseType

class NotFoundBrandException(
    message: String? = null,
) : BaseException(GlobalResponseType.NOT_FOUND_BRAND, message)
