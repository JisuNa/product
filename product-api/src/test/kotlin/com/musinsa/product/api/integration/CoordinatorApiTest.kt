package com.musinsa.product.api.integration

import com.musinsa.product.api.application.fasade.CoordinatorManager
import com.musinsa.product.api.presentation.CoordinatorController
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(controllers = [CoordinatorController::class])
class CoordinatorApiTest(
    @MockBean private val coordinatorManager: CoordinatorManager,
) : FunSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    @Autowired
    private lateinit var mockMvc: MockMvc

    init {
        extension(SpringExtension)

        test("카테고리 별 최저가 상품 조회") {
            mockMvc.get("$BASE_URL/category/min-price")
                .andExpect { status { isOk() } }
                .andReturn()
        }

        xtest("단일 브랜드 총액 최저가 상품 조회") {
            mockMvc.get("$BASE_URL/cheapest/brand")
                .andExpect { status { isOk() } }
                .andReturn()
        }
    }

    companion object {
        const val BASE_URL = "/api/product/coordinator"
    }
}
