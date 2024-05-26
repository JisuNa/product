package com.musinsa.product.api.application.processor

import com.musinsa.product.api.application.exception.NotFoundBrandException
import com.musinsa.product.domain.rdb.domain.dto.BrandDto
import com.musinsa.product.domain.rdb.domain.dto.ProductDto
import com.musinsa.product.domain.rdb.domain.repository.ProductRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.assertThrows

val productRepository = mockk<ProductRepository>()
val processor = CheapestBrandProductsProcessor(productRepository)

class CheapestBrandProductsProcessorTest : BehaviorSpec({
    given("단일 브랜드 최저가 조회가 요청된 상황에서") {
        `when`("최저가 브랜드가 존재하는 경우") {
            val brandDto = BrandDto(1, "D")
            val productDto = ProductDto(1, "D", 1, "상의",11_000)

            every { productRepository.findCheapestBrand() } returns brandDto
            every { productRepository.findProductsByBrandId(brandDto.brandId) } returns listOf(productDto)

            then("브랜드 정보와 그 브랜드의 제품 정보를 반환한다") {
                val result = processor.execute()
                result shouldBe brandDto
                result.products shouldBe listOf(productDto)
            }
        }

        `when`("최저가 브랜드가 존재하지 않는 경우") {
            every { productRepository.findCheapestBrand() } returns null

            then("NotFoundBrandException을 던진다") {
                assertThrows<NotFoundBrandException> {
                    processor.execute()
                }
            }
        }
    }
})