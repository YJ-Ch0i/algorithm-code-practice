package org.example.algorithm.common

import kotlin.reflect.KFunction

object TimeInterceptor {

    fun preTimeCheck(): Long
    {
        return System.nanoTime()
    }

    fun postTimeCheck(startTime: Long)
    {
        val endTime = System.nanoTime()
        val elapsedTime = endTime - startTime

        println("실행 시간 : ${elapsedTime / 1_000_000} ms")
    }
}

fun <R> wrapTimerFunction(
    function: KFunction<R>,
    vararg params: Any
): R
{
    val startTime = TimeInterceptor.preTimeCheck()
    val result = function.call(*params)
    TimeInterceptor.postTimeCheck(startTime)
    return result
}