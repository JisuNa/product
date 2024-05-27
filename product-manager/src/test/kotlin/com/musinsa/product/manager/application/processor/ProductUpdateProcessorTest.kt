package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.domain.rdb.domain.entity.Product
import com.musinsa.product.manager.application.exception.NotFoundBrandException
import com.musinsa.product.manager.application.exception.NotFoundCategoryException
import com.musinsa.product.manager.application.exception.NotFoundProductException
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import java.util.Optional
import org.junit.jupiter.api.assertThrows

val productUpdateProcessor = ProductUpdateProcessor(productRepository, brandRepository, categoryRepository)

class ProductUpdateProcessorTest : BehaviorSpec({
    given("상품 수정이 요청된 상황에서") {

        val productId = 1L
        val brandId = 1L
        val mockBrand = Brand("A")
        val categoryId = 1L
        val mockCategory = Category("상의")
        val price = 10_000

        `when`("요청값이 모두 입력되고 등록된 상품이 있는 경우") {

            val mockProduct = Product(price, mockBrand, mockCategory)

            every { productRepository.findById(productId) } returns Optional.of(mockProduct)
            every { brandRepository.findById(brandId) } returns Optional.of(mockBrand)
            every { categoryRepository.findById(categoryId) } returns Optional.of(mockCategory)
            every { productRepository.findByBrandAndCategory(any(), any()) } returns null

            then("정상적으로 수정된다.") {
                val result = productUpdateProcessor.execute(productId, price, brandId, categoryId)
                result shouldBe Unit
            }
        }

        `when`("수정할 상품이 없는 경우") {
            val notExistProductId = 99L

            every { productRepository.findById(notExistProductId) } returns Optional.empty()

            then("NotFoundProductException을 던진다") {
                assertThrows<NotFoundProductException> {
                    productUpdateProcessor.execute(notExistProductId, price, brandId, categoryId)
                }
            }
        }

        `when`("브랜드가 존재하지 않은 경우") {
            val notExistBrandId = 99999L
            val mockProduct = Product(price, mockBrand, mockCategory)

            every { productRepository.findById(productId) } returns Optional.of(mockProduct)
            every { brandRepository.findById(notExistBrandId) } returns Optional.empty()

            then("NotFoundBrandException을 던진다") {
                assertThrows<NotFoundBrandException> {
                    productUpdateProcessor.execute(productId, price, notExistBrandId, categoryId)
                }
            }
        }

        `when`("카테고리가 존재하지 않은 경우") {
            val notExistCategoryId = 99L
            val mockProduct = Product(price, mockBrand, mockCategory)

            every { productRepository.findById(productId) } returns Optional.of(mockProduct)
            every { brandRepository.findById(brandId) } returns Optional.of(mockBrand)
            every { categoryRepository.findById(notExistCategoryId) } returns Optional.empty()

            then("NotFoundCategoryException을 던진다") {
                assertThrows<NotFoundCategoryException> {
                    productUpdateProcessor.execute(productId, price, brandId, notExistCategoryId)
                }
            }
        }
    }
})
