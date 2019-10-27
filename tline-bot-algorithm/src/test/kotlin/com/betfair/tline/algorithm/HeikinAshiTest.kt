package com.betfair.tline.algorithm

import com.betfair.tline.algorithm.models.HeikinAshiCandle
import com.betfair.tline.models.MarketPeriod
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigDecimal

private val previousHeikinAshiCandle = HeikinAshiCandle(
    open = BigDecimal.valueOf(2.2),
    close = BigDecimal.valueOf(5.3),
    high = BigDecimal.valueOf(8.2),
    low = BigDecimal.valueOf(1.8)
)

private val currentMarketPeriod = MarketPeriod(
    open = BigDecimal.valueOf(3.2),
    close = BigDecimal.valueOf(6.3),
    high = BigDecimal.valueOf(9.2),
    low = BigDecimal.valueOf(2.8)
)

class HeikinAshiTest {

    private val heikinAshi = HeikinAshi()

    @Test
    fun `can generate a new heikin ashi candle`() {
        val newCandle = heikinAshi.next(previousHeikinAshiCandle, currentMarketPeriod)

        assertThat(newCandle.open).isEqualTo(BigDecimal.valueOf(3.75))
        assertThat(newCandle.close).isEqualTo(BigDecimal.valueOf(5.375))
        assertThat(newCandle.low).isEqualTo(BigDecimal.valueOf(2.8))
        assertThat(newCandle.high).isEqualTo(BigDecimal.valueOf(9.2))
    }
}
