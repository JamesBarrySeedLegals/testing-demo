package com.seedlegals.demo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `add two numbers`() {
        val calculator = Calculator()
        val result = calculator.add(1, 2)

        assertEquals(3, result)
    }
}