package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.manager.application.exception.NotFoundBrandException
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import java.util.Optional
import org.junit.jupiter.api.assertThrows

val brandRemoveProcessor = BrandRemoveProcessor(brandRepository)

class BrandRemoveProcessorTest : BehaviorSpec({
    given("브랜드 삭제가 요청된 상황에서") {
        `when`("요청값이 모두 입력되고 삭제할 브랜드가 존재하는 경우") {
            val requestBrandId = 1L
            val mockBrand = Brand("A")

            every { brandRepository.findById(any()) } returns Optional.of(mockBrand)
            every { brandRepository.delete(any()) } answers { nothing }

            then("정상적으로 삭제된다.") {
                val result = brandRemoveProcessor.execute(requestBrandId)
                result shouldBe Unit
            }
        }

        `when`("삭제할 브랜드가 존재하지 않는 경우") {
            every { brandRepository.findById(any()) } returns Optional.empty()

            then("NotFoundBrandException을 던진다") {
                assertThrows<NotFoundBrandException> {
                    brandRemoveProcessor.execute(1)
                }
            }
        }
    }
})