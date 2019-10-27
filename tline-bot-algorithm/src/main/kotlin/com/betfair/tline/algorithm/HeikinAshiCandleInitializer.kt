package com.betfair.tline.algorithm

import com.betfair.tline.algorithm.models.HeikinAshiCandle
import com.betfair.tline.models.MarketPeriod
import java.math.BigDecimal

class HeikinAshiCandleInitializer {

    fun initiateCandle(sequence: Sequence<MarketPeriod>): HeikinAshiCandle {
        // TODO: real implementation
        return HeikinAshiCandle(
            open = BigDecimal.ONE,
            close = BigDecimal.ONE,
            low = BigDecimal.ONE,
            high = BigDecimal.ONE
        )
    }
}
