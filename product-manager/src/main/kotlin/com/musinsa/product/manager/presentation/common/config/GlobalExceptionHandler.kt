package com.musinsa.product.manager.presentation.common.config

import com.musinsa.product.manager.application.exception.BaseException
import com.musinsa.product.manager.presentation.common.response.ErrorResponse
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(e: BaseException): ErrorResponse {
        return ErrorResponse(code = e.responseCode, message = e.message ?: "")
    }
}

