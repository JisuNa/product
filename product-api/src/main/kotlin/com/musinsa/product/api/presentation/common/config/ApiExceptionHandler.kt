package com.musinsa.product.api.presentation.common.config

import com.musinsa.product.api.application.exception.BaseException
import com.musinsa.product.api.presentation.common.response.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(e: BaseException): ErrorResponse {
        return ErrorResponse(code = e.responseCode, message = e.message ?: "")
    }
}