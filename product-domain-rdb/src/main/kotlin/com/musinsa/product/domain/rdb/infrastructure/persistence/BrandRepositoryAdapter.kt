package com.musinsa.product.domain.rdb.infrastructure.persistence

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaBrandRepository

class BrandRepositoryAdapter(
    private val jpaBrandRepository: JpaBrandRepository
) : BrandRepository {
    override fun findByName(brandName: String) :Brand? {
        val a = jpaBrandRepository.findByName(brandName)

        return a
    }

    override fun save(brandName: String) {
        jpaBrandRepository.save(Brand(brandName))
    }
}
