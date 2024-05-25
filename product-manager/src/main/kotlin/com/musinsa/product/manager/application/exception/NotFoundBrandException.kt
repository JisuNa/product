package com.musinsa.product.manager.application.exception

import com.musinsa.product.manager.application.common.GlobalResponseType

class NotFoundBrandException(
    message: String? = null,
) : BaseException(GlobalResponseType.NOT_FOUND_BRAND, message)
