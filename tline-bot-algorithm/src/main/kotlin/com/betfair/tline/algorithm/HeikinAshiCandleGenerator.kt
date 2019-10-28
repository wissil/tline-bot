package com.betfair.tline.algorithm

import com.betfair.tline.algorithm.models.HeikinAshiCandle
import com.betfair.tline.models.MarketPeriod

// https://docs.trendmaster.io/essential-knowledge/heikin-ashi#construction
class HeikinAshiCandleGenerator {

    fun firstCandle(
        firstMarketPeriod: MarketPeriod
    ): HeikinAshiCandle {
        val haClose = firstMarketPeriod
            .let { it.open + it.close + it.low + it.high }
            .divide(FOUR)

        val haOpen = firstMarketPeriod
            .let { it.open + it.close }
            .divide(TWO)

        val haLow = firstMarketPeriod.low

        val haHigh = firstMarketPeriod.high

        return HeikinAshiCandle(
            close = haClose,
            open = haOpen,
            low = haLow,
            high = haHigh
        )
    }

    fun nextCandle(
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
