package com.musinsa.product.manager.presentation

import com.musinsa.product.manager.application.fasade.BrandManager
import com.musinsa.product.manager.presentation.common.response.NoDataResponse
import com.musinsa.product.manager.presentation.request.BrandAddRequest
import com.musinsa.product.manager.presentation.request.BrandPutRequest
import com.musinsa.product.manager.presentation.request.BrandRemoveRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/manager/brands")
class BrandController(private val brandManager: BrandManager) {

    @PostMapping(name = "브랜드 추가")
    fun addBrand(@RequestBody @Validated request: BrandAddRequest): NoDataResponse {
        brandManager.addBrand(request.name)
        return NoDataResponse()
    }

    @PutMapping(name = "브랜드 수정")
    fun updateBrand(@RequestBody @Validated request: BrandPutRequest): NoDataResponse {
        brandManager.updateBrand(request.brandId, request.brandName)
        return NoDataResponse()
    }

    @DeleteMapping(name = "브랜드 삭제")
    fun removeBrand(@RequestBody @Validated request: BrandRemoveRequest): NoDataResponse {
        brandManager.removeBrand(request.brandId)
        return NoDataResponse()
    }
}