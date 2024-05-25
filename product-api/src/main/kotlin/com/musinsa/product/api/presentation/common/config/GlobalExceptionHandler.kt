package com.musinsa.product.api.presentation.common.config

import com.musinsa.product.api.application.exception.BaseException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import com.musinsa.product.api.presentation.common.response.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(e: BaseException): ErrorResponse {
        return ErrorResponse(code = e.responseCode, message = e.message ?: "")
    }
}