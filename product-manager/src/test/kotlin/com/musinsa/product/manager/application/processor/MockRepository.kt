package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.repository.BrandRepository
import com.musinsa.product.domain.rdb.domain.repository.CategoryRepository
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import io.mockk.mockk

val categoryRepository = mockk<CategoryRepository>()
val productRepository = mockk<ProductRepository>()
val brandRepository = mockk<BrandRepository>()