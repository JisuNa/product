package com.musinsa.product.manager.application.exception

import com.musinsa.product.manager.application.common.GlobalResponseType

class DuplicateProductException(
    message: String? = null,
) : BaseException(GlobalResponseType.DUPLICATE_PRODUCT, message)