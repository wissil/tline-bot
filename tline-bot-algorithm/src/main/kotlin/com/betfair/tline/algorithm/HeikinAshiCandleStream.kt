package com.betfair.tline.algorithm

import com.betfair.tline.algorithm.exceptions.EmptyStreamException
import com.betfair.tline.algorithm.models.HeikinAshiCandle
import com.betfair.tline.models.MarketPeriod
import mu.KotlinLogging
import java.util.stream.Stream
import javax.inject.Inject
import kotlin.streams.asSequence

private val logger = KotlinLogging.logger {}

class HeikinAshiCandleStream @Inject constructor(
    private val generator: HeikinAshiCandleGenerator
) {

    fun run(stream: Stream<MarketPeriod>): Sequence<HeikinAshiCandle> {
        logger.info { "Start streaming market periods" }

        return try {
            stream.asSequence().let { seq ->
                var currentCandle = generator.firstCandle(seq.first())

                seq.map {
                    currentCandle = generator.nextCandle(currentCandle, it)
                    return@map currentCandle
                }
            }
        } catch (e: NoSuchElementException) {
            logger.error(e) { "Empty stream provided" }
            throw EmptyStreamException(e)
        }
    }
}
