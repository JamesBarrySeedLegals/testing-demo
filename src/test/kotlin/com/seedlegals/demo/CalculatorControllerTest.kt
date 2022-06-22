package com.seedlegals.demo

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CalculatorController::class)
class CalculatorControllerTest {

    @TestConfiguration
    open class CalculatorControllerTestConfig {
        @Bean
        open fun calculatorService() = mockk<CalculatorService>().apply {
            every { add(2, 3) } returns 5
        }
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mockCalculatorService: CalculatorService

    @Test
    fun add() {
        mockMvc
            .perform(
                get("/add")
                    .queryParam("a", "2")
                    .queryParam("b", "3")
            )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("5")))

        verify { mockCalculatorService.add(2, 3) }
    }
}
