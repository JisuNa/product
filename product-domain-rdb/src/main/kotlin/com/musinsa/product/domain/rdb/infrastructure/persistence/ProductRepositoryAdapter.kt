package com.musinsa.product.domain.rdb.infrastructure.persistence

import com.musinsa.product.domain.rdb.domain.entity.Product
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import com.musinsa.product.domain.rdb.infrastructure.persistence.jpa.JpaProductRepository

class ProductRepositoryAdapter(
    private val jpaProductRepository: JpaProductRepository,
) : ProductRepository {
    override fun findMinPriceProductsByCategory() = jpaProductRepository.findMinPriceProductsByCategory()

    override fun findCheapestBrand() = jpaProductRepository.findCheapestBrand()

    override fun findProductsByBrandId(brandId: Long) = jpaProductRepository.findProductsByBrandId(brandId)

    override fun findMinPriceProductByCategoryId(id: Long) = jpaProductRepository.findMinPriceProductByCategory(id)

    override fun findMaxPriceProductsByCategory(id: Long) = jpaProductRepository.findMaxPriceProductByCategory(id)
}
