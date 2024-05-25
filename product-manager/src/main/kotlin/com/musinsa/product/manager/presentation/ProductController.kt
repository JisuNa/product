package com.musinsa.product.manager.presentation

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin/products")
class ProductController {

    @PostMapping("/add", name ="상품 추가")
    fun addProduct() {

    }

    @GetMapping(name = "상품 목록 조회")
    fun getProducts() {

    }

    @PutMapping("/modify", name = "상품 수정")
    fun modifyProduct() {

    }

    @DeleteMapping("/remove", name = "상품 삭제")
    fun removeProduct() {

    }
}