package com.musinsa.product.manager.integration

import com.musinsa.product.manager.application.fasade.ProductManager
import com.musinsa.product.manager.presentation.ProductController
import com.musinsa.product.manager.presentation.request.ProductAddRequest
import com.musinsa.product.manager.presentation.request.ProductPutRequest
import com.musinsa.product.manager.presentation.request.ProductRemoveRequest
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put

@WebMvcTest(controllers = [ProductController::class])
class ProductApiTest(
    @MockBean private val productManager: ProductManager
) : FunSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    @Autowired
    private lateinit var mockMvc: MockMvc

    init {
        extension(SpringExtension)

        context("상품 추가") {
            test("성공") {
                mockMvc.post(BASE_URL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(ProductAddRequest(1L, 1L, 10_000))
                }.andExpect { status { isOk() } }
            }

            test("실패 - 파라미터 입력 안함") {
                mockMvc.post(BASE_URL).andExpect { status { isBadRequest() } }
            }

            test("실패 - 가격 0원으로 입력") {
                mockMvc.post(BASE_URL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(ProductAddRequest(1L, 1L, 0))
                }.andExpect { status { isBadRequest() } }
            }

        }

        context("상품 수정") {
            test("성공") {
                mockMvc.put(BASE_URL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(ProductPutRequest(1L, 10_000, 1L, 1L))
                }.andExpect { status { isOk() } }
            }

            test("실패 - 파라미터 입력 안함") {
                mockMvc.put(BASE_URL).andExpect { status { isBadRequest() } }
            }
        }

        context("상품 삭제") {
            test("성공") {
                mockMvc.delete(BASE_URL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(ProductRemoveRequest(1L))
                }.andExpect { status { isOk() } }
            }

            test("실패 - 파라미터 입력 안함") {
                mockMvc.delete(BASE_URL).andExpect { status { isBadRequest() } }
            }
        }
    }

    companion object {
        const val BASE_URL = "/manager/products"
    }
}
