package com.musinsa.product.manager.application.exception

import com.musinsa.product.manager.application.common.GlobalResponseType

class NotFoundCategoryException(
    message: String? = null,
) : BaseException(GlobalResponseType.NOT_FOUND_CATEGORY, message)
