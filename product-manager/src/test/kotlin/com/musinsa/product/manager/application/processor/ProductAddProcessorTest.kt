package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.domain.rdb.domain.entity.Product
import com.musinsa.product.manager.application.exception.DuplicateProductException
import com.musinsa.product.manager.application.exception.NotFoundBrandException
import com.musinsa.product.manager.application.exception.NotFoundCategoryException
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import java.util.Optional
import org.junit.jupiter.api.assertThrows

val productAddProcessor = ProductAddProcessor(productRepository, brandRepository, categoryRepository)

class ProductAddProcessorTest : BehaviorSpec({
    given("상품 등록이 요청된 상황에서") {
        val brandId = 1L
        val brandName = "A"
        val categoryId = 1L
        val categoryName = "상의"
        val price = 10_000

        `when`("요청값이 모두 입력되고 이미 등록된 상품이 없는 경우") {

            every { brandRepository.findById(any()) } returns Optional.of(Brand(brandName))
            every { categoryRepository.findById(any()) } returns Optional.of(Category(categoryName))
            every { productRepository.findByBrandAndCategory(any(), any()) } returns null
            every { productRepository.save(any()) } returns Unit

            then("정상적으로 등록된다.") {
                val result = productAddProcessor.execute(brandId, categoryId, price)
                result shouldBe Unit
            }
        }

        `when`("브랜드가 존재하지 않은 경우") {

            every { brandRepository.findById(any()) } returns Optional.empty()

            then("NotFoundBrandException을 던진다") {
                assertThrows<NotFoundBrandException> {
                    productAddProcessor.execute(brandId, categoryId, price)
                }
            }
        }

        `when`("카테고리가 존재하지 않은 경우") {

            every { brandRepository.findById(any()) } returns Optional.of(Brand(brandName))
            every { categoryRepository.findById(any()) } returns Optional.empty()

            then("NotFoundCategoryException을 던진다") {
                assertThrows<NotFoundCategoryException> {
                    productAddProcessor.execute(brandId, categoryId, price)
                }
            }
        }

        `when`("이미 등록된 상품일 경우") {

            every { brandRepository.findById(any()) } returns Optional.of(Brand(brandName))
            every { categoryRepository.findById(any()) } returns Optional.of(Category(categoryName))
            every {
                productRepository.findByBrandAndCategory(any(), any())
            } returns Product(price, Brand(brandName), Category(categoryName))

            then("DuplicateProductException을 던진다") {
                assertThrows<DuplicateProductException> {
                    productAddProcessor.execute(brandId, categoryId, price)
                }
            }
        }
    }
})
