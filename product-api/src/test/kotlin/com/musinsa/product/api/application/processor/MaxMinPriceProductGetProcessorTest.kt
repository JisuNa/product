package com.musinsa.product.api.application.processor

import com.musinsa.product.api.application.exception.NotFoundCategoryException
import com.musinsa.product.api.application.exception.NotFoundProductException
import com.musinsa.product.api.application.vo.MaxMinPriceProductVo
import com.musinsa.product.domain.rdb.domain.dto.ProductDto
import com.musinsa.product.domain.rdb.domain.entity.Category
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.junit.jupiter.api.assertThrows

val maxMinPriceProductGetProcessor = MaxMinPriceProductGetProcessor(categoryRepository, productRepository)

class MaxMinPriceProductGetProcessorTest : BehaviorSpec({

    given("카테고리 이름으로 최대, 최소 가격의 제품 조회가 요청된 상황에서") {
        `when`("해당 카테고리와 제품이 존재하는 경우") {
            val categoryName = "상의"
            val minPriceProductDto = ProductDto(1, "A", 1, "상의", 1_000)
            val maxPriceProductDto = ProductDto(2, "B", 2, "상의", 10_000)
            val mockCategory = Category(categoryName)

            every { categoryRepository.findCategoryByName(any()) } returns mockCategory
            every { productRepository.findMinPriceProductByCategoryId(any()) } returns minPriceProductDto
            every { productRepository.findMaxPriceProductsByCategory(any()) } returns maxPriceProductDto

            then("카테고리 이름과 최소, 최대 가격의 제품 정보를 반환한다") {
                val result = maxMinPriceProductGetProcessor.execute(categoryName)
                result shouldBe MaxMinPriceProductVo.of(categoryName, minPriceProductDto, maxPriceProductDto)
            }
        }

        `when`("해당 카테고리가 존재하지 않는 경우") {
            val categoryName = "속옷"

            every { categoryRepository.findCategoryByName(any()) } returns null

            then("NotFoundCategoryException을 던진다") {
                assertThrows<NotFoundCategoryException> {
                    maxMinPriceProductGetProcessor.execute(categoryName)
                }
            }
        }

        `when`("해당 카테고리의 제품이 존재하지 않는 경우") {
            val categoryName = "하의"
            val mockCategory = Category(categoryName)

            every { categoryRepository.findCategoryByName(any()) } returns mockCategory
            every { productRepository.findMinPriceProductByCategoryId(any()) } returns null
            every { productRepository.findMaxPriceProductsByCategory(any()) } returns null

            then("NotFoundProductException을 던진다") {
                assertThrows<NotFoundProductException> {
                    maxMinPriceProductGetProcessor.execute(categoryName)
                }
            }
        }
    }
})