package org.example.algorithm.common

import kotlin.reflect.KFunction

/**
 * 함수 실행 시간 계산을 위한 선행/후행 함수 호출
 */
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

/**
 * 시간 계산을 위해 감싸줄 함수
 */
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