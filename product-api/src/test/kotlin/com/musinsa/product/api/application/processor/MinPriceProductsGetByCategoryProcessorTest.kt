package com.musinsa.product.api.application.processor

import com.musinsa.product.api.application.exception.NotFoundBrandException
import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.junit.jupiter.api.assertThrows

class MinPriceProductsGetByCategoryProcessorTest : BehaviorSpec({
    given("단일 브랜드 총액 최저가 상품 조회 요청된 상황에서") {
        `when`("브랜드의 최저가가 존재하는 경우") {
            val mockBrandDto = BrandDto(1, "D")
            val mockProductDto = ProductDto(1, "D", 1, "상의", 11_000)

            every { productRepository.findCheapestBrand() } returns mockBrandDto
            every { productRepository.findProductsByBrandId(any()) } returns listOf(mockProductDto)

            then("브랜드와 제품 정보를 반환한다") {
                val result = cheapestBrandProductsProcessor.execute()
                result shouldBe mockBrandDto
                result.products shouldBe listOf(mockProductDto)
            }
        }

        `when`("최저가 브랜드가 존재하지 않는 경우") {
            every { productRepository.findCheapestBrand() } returns null

            then("NotFoundBrandException을 던진다") {
                assertThrows<NotFoundBrandException> {
                    cheapestBrandProductsProcessor.execute()
                }
            }
        }
    }
})
