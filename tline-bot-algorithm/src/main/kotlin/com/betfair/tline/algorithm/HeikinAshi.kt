package com.betfair.tline.algorithm

import com.betfair.tline.algorithm.models.HeikinAshiCandle
import com.betfair.tline.algorithm.models.JapaneseCandle
import java.math.BigDecimal

// pre-cache for performance reasons
private val FOUR = BigDecimal(4L)
private val TWO = BigDecimal(2L)

// https://docs.trendmaster.io/essential-knowledge/heikin-ashi#construction
class HeikinAshi {

    fun next(
        previousHaCandle: HeikinAshiCandle,
        currentJapaneseCandle: JapaneseCandle
    ): HeikinAshiCandle {
        val haClose = currentJapaneseCandle
            .let { it.open + it.close + it.low + it.high }
            .divide(FOUR)

        val haOpen = previousHaCandle
            .let { it.open + it.close }
            .divide(TWO)

        val haLow = minOfThree(currentJapaneseCandle.low, haOpen, haClose)

        val haHigh = maxOfThree(currentJapaneseCandle.high, haOpen, haClose)

        return HeikinAshiCandle(
            close = haClose,
            open = haOpen,
            low = haLow,
            high = haHigh
        )
    }
}

// custom methods for performance reasons
private fun maxOfThree(n1: BigDecimal, n2: BigDecimal, n3: BigDecimal): BigDecimal {
    return n1.max(n2).max(n3)
}

private fun minOfThree(n1: BigDecimal, n2: BigDecimal, n3: BigDecimal): BigDecimal {
    return n1.min(n2).min(n3)
}
