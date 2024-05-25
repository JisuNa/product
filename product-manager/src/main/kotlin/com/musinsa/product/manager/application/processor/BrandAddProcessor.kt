package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.manager.application.exception.DuplicateBrandException

class BrandAddProcessor(private val brandRepository: BrandRepository) {
    fun execute(brandName: String) {
        brandRepository.findByName(brandName)?.also {
            throw DuplicateBrandException()
        } ?: run {
            brandRepository.save(brandName)
        }
    }
}
