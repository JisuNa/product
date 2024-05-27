package com.musinsa.product.manager.presentation.common.config

import com.musinsa.product.manager.application.common.GlobalResponseType
import com.musinsa.product.manager.application.exception.BaseException
import com.musinsa.product.manager.presentation.common.response.ErrorResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException

@RestControllerAdvice
class ManagerExceptionHandler {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(e: BaseException): ErrorResponse {
        return ErrorResponse(code = e.responseCode, message = e.message ?: "")
    }

    @ExceptionHandler(HandlerMethodValidationException::class)
    fun handleHandlerMethodValidationException(e: HandlerMethodValidationException): ErrorResponse {
        return ErrorResponse(GlobalResponseType.BAD_REQUEST, e.reason ?: "")
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(e: DataIntegrityViolationException): ErrorResponse {
        return ErrorResponse(GlobalResponseType.CONFLICT, e.message ?: "")
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(e: ConstraintViolationException): ErrorResponse {
        return ErrorResponse(GlobalResponseType.BAD_REQUEST, e.message ?: "")
    }
}
