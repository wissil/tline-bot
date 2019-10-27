package com.betfair.tline.algorithm.heikinashi.models

import java.math.BigDecimal

data class HeikinAshiCandle(
    val open: BigDecimal,
    val close: BigDecimal,
    val high: BigDecimal,
    val low: BigDecimal
)
