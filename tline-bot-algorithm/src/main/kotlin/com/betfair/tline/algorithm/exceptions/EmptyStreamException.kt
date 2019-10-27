package com.betfair.tline.algorithm.exceptions

class EmptyStreamException(e: Exception) : Exception("Provided stream is empty", e)
