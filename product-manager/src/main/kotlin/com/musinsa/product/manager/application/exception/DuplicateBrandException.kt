package com.musinsa.product.manager.application.exception

import com.musinsa.product.manager.application.common.GlobalResponseType

class DuplicateBrandException(
    message: String? = null,
) : BaseException(GlobalResponseType.DUPLICATE_BRAND, message)
