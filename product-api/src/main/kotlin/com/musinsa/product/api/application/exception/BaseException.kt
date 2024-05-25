package com.musinsa.product.api.application.exception

import com.musinsa.product.api.application.common.GlobalResponseType

open class BaseException(
    val responseCode: GlobalResponseType,
    message: String? = null,
) : RuntimeException(message ?: responseCode.defaultMessage)