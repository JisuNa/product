package com.musinsa.product.api.integration

import com.musinsa.product.api.application.fasade.ProductPriceManager
import com.musinsa.product.api.presentation.ProductPriceController
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.web.servlet.function.RequestPredicates.param

@WebMvcTest(controllers = [ProductPriceController::class])
class ProductPriceApiTest(
    @MockBean private val productPriceManager: ProductPriceManager,
) : FunSpec() {

    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    @Autowired
    private lateinit var mockMvc: MockMvc

    init {
        extension(SpringExtension)

        context("카테고리 최고가 최저가 상품 조회") {
            val request = mockMvc.get("$BASE_URL/max-min")

            test("성공") {
                request.andDo { param("categoryName", "상의") }
                    .andExpect { status { isBadRequest() } }
            }

            test("실패 - 카테고리 입력 안함") {
                request.andExpect { status { isBadRequest() } }
            }

            test("실패 - 존재하지 않은 카테고리 입력") {
                request.andDo { param("categoryName", "존재하지 않는 카테고리") }
                    .andExpect { status { isBadRequest() } }
            }
        }
    }

    companion object {
        const val BASE_URL = "/api/product/price"
    }
}
