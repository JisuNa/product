package com.musinsa.product.manager.application.common

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.http.HttpStatus

enum class GlobalResponseType(
    @get:JsonValue
    val code: String,
    val httpStatus: HttpStatus,
    val defaultMessage: String
) {
    OK("200", HttpStatus.OK, "요청이 성공하였습니다."),
    BAD_REQUEST("400", HttpStatus.BAD_REQUEST, "요청하신 데이터가 올바르지 않습니다."),
    NOT_FOUND_CATEGORY("404", HttpStatus.NOT_FOUND, "카테고리를 찾을 수 없습니다."),
    NOT_FOUND_BRAND("404", HttpStatus.NOT_FOUND, "브랜드를 찾을 수 없습니다."),
    NOT_FOUND_PRODUCT("404", HttpStatus.NOT_FOUND, "상품을 찾을 수 없습니다."),
    DUPLICATE_BRAND("409", HttpStatus.NOT_FOUND, "이미 등록된 브랜드입니다"),
    DUPLICATE_PRODUCT("409", HttpStatus.NOT_FOUND, "이미 등록된 상품입니다"),
}
