package com.musinsa.product.manager.application.fasade

import com.musinsa.product.manager.application.processor.BrandAddProcessor
import com.musinsa.product.manager.application.processor.BrandRemoveProcessor
import com.musinsa.product.manager.application.processor.BrandUpdateProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BrandManager(
    private val brandAddProcessor: BrandAddProcessor,
    private val brandUpdateProcessor: BrandUpdateProcessor,
    private val brandRemoveProcessor: BrandRemoveProcessor
) {
    @Transactional
    fun addBrand(brandName: String) {
        brandAddProcessor.execute(brandName)
    }

    @Transactional
    fun updateBrand(id: Long, name: String) {
        brandUpdateProcessor.execute(id, name)
    }

    fun removeBrand(brandId: Long) {
        brandRemoveProcessor.execute(brandId)
    }
}