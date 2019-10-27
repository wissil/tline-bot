package com.betfair.tline.algorithm

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigDecimal

class UtilsTest {

    private val biggest = BigDecimal.valueOf(3L)
    private val middle = BigDecimal.valueOf(2L)
    private val smallest = BigDecimal.valueOf(1L)

    @Test
    fun `should return the biggest of 3 BigDecimals`() {
        val result = maxOfThree(biggest, middle, smallest)

        assertThat(result).isEqualTo(biggest)
    }

    @Test
    fun `should return the smallest of 3 BigDecimals`() {
        val result = minOfThree(biggest, middle, smallest)

        assertThat(result).isEqualTo(smallest)
    }

    @Test
    fun `input order should not affect the smallest result`() {
        val order1Result = minOfThree(biggest, middle, smallest)
        val order2Result = minOfThree(biggest, smallest, middle)
        val order3Result = minOfThree(middle, biggest, smallest)
        val order4Result = minOfThree(middle, smallest, biggest)
        val order5Result = minOfThree(smallest, biggest, middle)
        val order6Result = minOfThree(smallest, middle, biggest)

        assertThat(listOf(order1Result, order2Result, order3Result,
            order4Result, order5Result, order6Result)
            .all { it == smallest }
        )
    }

    @Test
    fun `input order should not affect the biggest result`() {
        val order1Result = maxOfThree(biggest, middle, smallest)
        val order2Result = maxOfThree(biggest, smallest, middle)
        val order3Result = maxOfThree(middle, biggest, smallest)
        val order4Result = maxOfThree(middle, smallest, biggest)
        val order5Result = maxOfThree(smallest, biggest, middle)
        val order6Result = maxOfThree(smallest, middle, biggest)

        assertThat(listOf(order1Result, order2Result, order3Result,
            order4Result, order5Result, order6Result)
            .all { it == biggest }
        )
    }
}
