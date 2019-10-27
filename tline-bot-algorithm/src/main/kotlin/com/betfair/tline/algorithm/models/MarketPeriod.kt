package com.betfair.tline.algorithm.models

import java.math.BigDecimal

data class MarketPeriod(
    val open: BigDecimal,
    val close: BigDecimal,
    val high: BigDecimal,
    val low: BigDecimal
)
