package com.musinsa.product.manager.presentation

import com.musinsa.product.manager.application.fasade.ProductManager
import com.musinsa.product.manager.presentation.common.response.NoDataResponse
import com.musinsa.product.manager.presentation.request.ProductAddRequest
import com.musinsa.product.manager.presentation.request.ProductPutRequest
import com.musinsa.product.manager.presentation.request.ProductRemoveRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/manager/products")
class ProductController(private val productManager: ProductManager) {

    @PostMapping(name = "상품 추가")
    fun addProduct(@RequestBody @Validated request: ProductAddRequest): NoDataResponse {
        productManager.addProduct(request.brandId, request.categoryId, request.price)
        return NoDataResponse()
    }

    @PutMapping("/{productId}", name = "상품 수정")
    fun modifyProduct(
        @PathVariable productId: Long,
        @RequestBody @Validated request: ProductPutRequest
    ): NoDataResponse {
        productManager.modifyProduct(productId, request.price, request.brandId, request.categoryId)
        return NoDataResponse()
    }

    @DeleteMapping("/{productId}", name = "상품 삭제")
    fun removeProduct(@PathVariable productId: Long): NoDataResponse {
        productManager.removeProduct(productId)
        return NoDataResponse()
    }
}
