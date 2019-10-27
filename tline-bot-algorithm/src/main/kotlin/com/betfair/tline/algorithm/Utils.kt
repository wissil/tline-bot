package com.betfair.tline.algorithm

import java.math.BigDecimal

// pre-cache for performance reasons
val FOUR = BigDecimal(4L)
val TWO = BigDecimal(2L)

// custom methods for performance reasons
fun maxOfThree(n1: BigDecimal, n2: BigDecimal, n3: BigDecimal): BigDecimal {
    return n1.max(n2).max(n3)
}

fun minOfThree(n1: BigDecimal, n2: BigDecimal, n3: BigDecimal): BigDecimal {
    return n1.min(n2).min(n3)
}
