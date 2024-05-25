package com.musinsa.product.domain.rdb.infrastructure.persistence

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaBrandRepository

class BrandRepositoryAdapter(
    private val jpaBrandRepository: JpaBrandRepository
) : BrandRepository {

}