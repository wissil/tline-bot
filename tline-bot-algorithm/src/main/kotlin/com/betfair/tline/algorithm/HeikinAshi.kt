package com.betfair.tline.algorithm

import com.betfair.tline.algorithm.models.HeikinAshiCandle
import com.betfair.tline.algorithm.models.MarketPeriod
import java.math.BigDecimal

// pre-cache for performance reasons
private val FOUR = BigDecimal(4L)
private val TWO = BigDecimal(2L)

// https://docs.trendmaster.io/essential-knowledge/heikin-ashi#construction
class HeikinAshi {

    fun next(
        previousHaCandle: HeikinAshiCandle,
        currentMarketPeriod: MarketPeriod
    ): HeikinAshiCandle {
        val haClose = currentMarketPeriod
            .let { it.open + it.close + it.low + it.high }
            .divide(FOUR)

        val haOpen = previousHaCandle
            .let { it.open + it.close }
            .divide(TWO)

        val haLow = minOfThree(currentMarketPeriod.low, haOpen, haClose)

        val haHigh = maxOfThree(currentMarketPeriod.high, haOpen, haClose)

        return HeikinAshiCandle(
            close = haClose,
            open = haOpen,
            low = haLow,
            high = haHigh
        )
    }
}
