package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.manager.application.exception.NotFoundBrandException
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import java.util.Optional
import org.junit.jupiter.api.assertThrows

val brandUpdateProcessor = BrandUpdateProcessor(brandRepository)

class BrandUpdateProcessorTest : BehaviorSpec({
    given("브랜드 수정이 요청된 상황에서") {
        `when`("요청값이 모두 입력되고 이미 등록된 브랜드가 있는 경우") {
            val brandId = 1L
            val brandName = "무신사 스탠다드"
            val mockBrand = Brand(brandName)

            every { brandRepository.findById(any()) } returns Optional.of(mockBrand)

            then("정상적으로 수정된다.") {
                val result = brandUpdateProcessor.execute(brandId, brandName)
                result shouldBe Unit
            }
        }

        `when`("수정할 브랜드가 없는 경우") {
            val brandId = 99L

            every { brandRepository.findById(any()) } returns Optional.empty()

            then("NotFoundBrandException을 던진다") {
                assertThrows<NotFoundBrandException> {
                    brandUpdateProcessor.execute(brandId, "Z")
                }
            }
        }
    }
})