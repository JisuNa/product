package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.manager.application.exception.NotFoundBrandException

class BrandRemoveProcessor(private val brandRepository: BrandRepository) {
    fun execute(brandId: Long) {
        brandRepository.findById(brandId).orElseThrow { NotFoundBrandException() }
            .also { brandRepository.delete(it) }
    }
}