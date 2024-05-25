package com.musinsa.product.domain.rdb.infrastructure.persistence.jpa

import com.musinsa.product.domain.rdb.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface JpaProductRepository : JpaRepository<Product, Long>, JpaProductRepositoryCustom
