package com.betfair.tline.algorithm

import com.betfair.tline.models.MarketPeriod
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigDecimal

class HeikinAshiCandleStreamTest {

    private val marketPeriods = listOf(
        MarketPeriod(
            open = BigDecimal.valueOf(3.2),
            close = BigDecimal.valueOf(6.3),
            high = BigDecimal.valueOf(9.2),
            low = BigDecimal.valueOf(2.8)
        ),
        MarketPeriod(
            open = BigDecimal.valueOf(4.2),
            close = BigDecimal.valueOf(7.3),
            high = BigDecimal.valueOf(5.2),
            low = BigDecimal.valueOf(2.5)
        ),
        MarketPeriod(
            open = BigDecimal.valueOf(3.2),
            close = BigDecimal.valueOf(6.3),
            high = BigDecimal.valueOf(11.2),
            low = BigDecimal.valueOf(6.8)
        ),
        MarketPeriod(
            open = BigDecimal.valueOf(6.2),
            close = BigDecimal.valueOf(6.3),
            high = BigDecimal.valueOf(5.5),
            low = BigDecimal.valueOf(4.1)
        )
    ).stream()

    private val generator = HeikinAshiCandleGenerator()
    private val initializer = HeikinAshiCandleInitializer()

    private val candleStream = HeikinAshiCandleStream(
        generator = generator,
        initializer = initializer
    )

    @Test
    fun `should map the whole stream`() {
        candleStream.run(marketPeriods).forEach {
            assertThat(it).isNotNull()
        }
    }
}
