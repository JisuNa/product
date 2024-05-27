package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.manager.application.exception.DuplicateBrandException
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.junit.jupiter.api.assertThrows

val brandAddProcessor = BrandAddProcessor(brandRepository)

class BrandAddProcessorTest: BehaviorSpec({
    given("브랜드 등록이 요청된 상황에서") {
        `when`("요청값이 모두 입력되고 이미 등록된 브랜드가 없는 경우") {

            val brandName = "무신사 스탠다드"

            every { brandRepository.findByName(any()) } returns null
            every { brandRepository.save(any()) } answers { nothing }

            then("정상적으로 등록된다.") {
                val result = brandAddProcessor.execute(brandName)
                result shouldBe Unit
            }
        }

        `when`("이미 등록된 브랜드일 경우") {
            val mockBrand = Brand("A")

            every { brandRepository.findByName(any()) } returns mockBrand

            then("DuplicateBrandException을 던진다") {
                assertThrows<DuplicateBrandException> {
                    brandAddProcessor.execute("A")
                }
            }
        }
    }
})
