package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.manager.application.exception.NotFoundBrandException

class BrandUpdateProcessor(private val brandRepository: BrandRepository) {
    fun execute(id: Long, name: String) {
        brandRepository.findById(id).orElseThrow { NotFoundBrandException() }
            .apply { this.name = name }
    }
}