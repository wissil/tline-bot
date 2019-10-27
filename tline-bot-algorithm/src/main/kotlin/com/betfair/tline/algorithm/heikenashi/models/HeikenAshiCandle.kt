package com.betfair.tline.algorithm.heikenashi.models

import java.math.BigDecimal

data class HeikenAshiCandle(
    val open: BigDecimal,
    val close: BigDecimal,
    val high: BigDecimal,
    val low: BigDecimal
)
