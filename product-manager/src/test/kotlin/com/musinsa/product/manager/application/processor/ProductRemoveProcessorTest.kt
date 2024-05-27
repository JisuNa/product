package com.musinsa.product.manager.application.processor

import com.musinsa.product.domain.rdb.domain.entity.Brand
import com.musinsa.product.domain.rdb.domain.entity.Category
import com.musinsa.product.domain.rdb.domain.entity.Product
import com.musinsa.product.manager.application.exception.NotFoundProductException
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import java.util.Optional
import org.junit.jupiter.api.assertThrows

val productRemoveProcessor = ProductRemoveProcessor(productRepository)

class ProductRemoveProcessorTest : BehaviorSpec({
    given("상품 삭제가 요청된 상황에서") {
        `when`("요청값이 모두 입력되고 이미 등록된 상품이 있는 경우") {
            val productId = 1L
            val mockProduct = Product(10_000, Brand("A"), Category("상의"))

            every { productRepository.findById(any()) } returns Optional.of(mockProduct)
            every { productRepository.delete(any()) } returns Unit

            then("정상적으로 삭제된다.") {
                val result = productRemoveProcessor.execute(productId)
                result shouldBe Unit
            }
        }

        `when`("삭제할 상품이 없는 경우") {
            val productId = 99L

            every { productRepository.findById(productId) } returns Optional.empty()

            then("NotFoundProductException을 던진다") {
                assertThrows<NotFoundProductException> {
                    productRemoveProcessor.execute(productId)
                }
            }
        }
    }
})