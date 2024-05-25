package com.musinsa.product.domain.rdb.infrastructure.persistence

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaBrandRepository
import java.util.Optional

class BrandRepositoryAdapter(
    private val jpaBrandRepository: JpaBrandRepository
) : BrandRepository {
    override fun findByName(brandName: String) = jpaBrandRepository.findByName(brandName)

    override fun save(brandName: String) {
        jpaBrandRepository.save(Brand(brandName))
    }

    override fun findById(id: Long): Optional<Brand> =  jpaBrandRepository.findById(id)
    override fun delete(brand: Brand) {
        jpaBrandRepository.delete(brand)
    }
}
