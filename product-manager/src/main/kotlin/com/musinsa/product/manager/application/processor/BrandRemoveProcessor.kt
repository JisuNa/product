package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.manager.application.exception.NotFoundBrandException

class BrandRemoveProcessor(private val brandRepository: BrandRepository) {
    fun execute(brandId: Long) {
        val brand = findBrandById(brandId)
        deleteBrand(brand)
    }

    private fun findBrandById(brandId: Long): Brand {
        return brandRepository.findById(brandId).orElseThrow { NotFoundBrandException() }
    }

    private fun deleteBrand(brand: Brand) {
        brandRepository.delete(brand)
    }
}