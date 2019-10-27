package com.betfair.tline.algorithm.models

import java.math.BigDecimal

data class HeikinAshiCandle(
    val close: BigDecimal,
    val open: BigDecimal,
    val low: BigDecimal,
    val high: BigDecimal
)
