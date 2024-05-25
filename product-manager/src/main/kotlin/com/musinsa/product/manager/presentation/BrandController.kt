package com.musinsa.product.manager.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin/brands")
class BrandController {

    @PostMapping(name = "상품 추가")
    fun addProduct() {

    }
}