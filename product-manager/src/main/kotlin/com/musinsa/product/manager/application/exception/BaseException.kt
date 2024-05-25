package com.musinsa.product.manager.application.exception

import com.musinsa.product.manager.application.common.GlobalResponseType

open class BaseException(
    val responseCode: GlobalResponseType,
    message: String? = null,
) : RuntimeException(message ?: responseCode.defaultMessage)