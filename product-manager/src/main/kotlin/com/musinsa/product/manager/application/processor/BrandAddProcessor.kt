package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.manager.application.exception.DuplicateBrandException

class BrandAddProcessor(private val brandRepository: BrandRepository) {
    fun execute(brandName: String) {
        checkDuplicateBrand(brandName)
        brandRepository.save(Brand(brandName))
    }

    private fun checkDuplicateBrand(brandName: String) {
        brandRepository.findByName(brandName)?.run { throw DuplicateBrandException() }
    }
}
