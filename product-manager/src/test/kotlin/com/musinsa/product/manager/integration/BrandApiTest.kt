package com.musinsa.product.manager.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.musinsa.product.manager.application.fasade.BrandManager
import com.musinsa.product.manager.presentation.BrandController
import com.musinsa.product.manager.presentation.request.BrandAddRequest
import com.musinsa.product.manager.presentation.request.BrandPutRequest
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

val objectMapper = ObjectMapper()

@WebMvcTest(controllers = [BrandController::class])
class BrandApiTest(
    @MockBean private val brandManager: BrandManager
) : FunSpec() {

    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest

    @Autowired
    private lateinit var mockMvc: MockMvc

    init {
        extension(SpringExtension)

        context("브랜드 추가") {
            test("성공") {
                mockMvc.post(BASE_URL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(BrandAddRequest("Z"))
                }.andExpect { status { isOk() } }
            }

            test("실패 - 브랜드 이름 입력 안함") {
                mockMvc.post(BASE_URL).andExpect { status { isBadRequest() } }
            }
        }

        context("브랜드 수정") {
            test("성공") {
                mockMvc.put("$BASE_URL/{brandId}", 1) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(BrandPutRequest("Z"))
                }.andExpect { status { isOk() } }
            }

            test("실패 - 브랜드 이름 입력 안함") {
                mockMvc.put("$BASE_URL/{brandId}", 1).andExpect { status { isBadRequest() } }
            }
        }

        context("브랜드 삭제") {
            test("성공") {
                mockMvc.delete("$BASE_URL/{brandId}", 1)
                    .andExpect { status { isOk() } }
            }
        }
    }

    companion object {
        const val BASE_URL = "/manager/brands"
    }
}
