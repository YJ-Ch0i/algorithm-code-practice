package org.example.algorithm.greedy

import org.example.algorithm.common.wrapTimerFunction

class GreedyLargeNumber {

    /**
     * 큰 수의 법칙?
     * 크기가 N의 배열이 주어진다.
     * 배열에 주어진 수들을 M번 더하여 가장 큰 수를 만든다.
     * 배열의 특정 인덱스에 해당하는 수가 연속하여 K번 초과하여 더해질 수 없다.
     */

    /**
     * 배열의 크기 N, 숫자가 더해지는 횟수 M, 연속가능 횟수 K
     * 크기가 N인 배열이 존재한다. 각각의 자연수는 1 이상 10000 이하이다.
     * K는 항상 M보다 작거나 같다.
     */

    fun solutionFirst(
        array: IntArray,
        m: Int,
        k: Int,
    )
    {
        val sorted = array.sortedDescending()
        val first = sorted[0]
        val second = sorted[1]

        var result = 0

        var countOfSum = m

        while(true)
        {
            // 가장 큰 값 합산
            run block@ {
                repeat(k){
                    if(countOfSum == 0) return@block
                    result += first
                    countOfSum--
                }
            }
            // m은 초기값 0이 아님. 따라서 1회차 반복이 진행되어야 함.
            if(countOfSum == 0) break

            // 2번째 큰 값 합산
            result += second
            countOfSum--
        }

        println(result)
    }

    fun solutionSecond(
        array: IntArray,
        m: Int,
        k: Int,
    )
    {
        val sorted = array.sortedDescending()
        val first = sorted[0]
        val second = sorted[1]

        var result = 0
        var repeatCount = (m / (k+1)) * k // -> 2 * 3 = 6
        repeatCount += (m % (k+1)) // -> 6 + 9%4 -> 1 -> 6+1 = 7

        result += repeatCount * first
        result += (m - repeatCount) * second

        println(result)
    }
}

fun main(){
    val gln = GreedyLargeNumber()
    val array = intArrayOf(2, 3, 4, 5, 6, 6, 7, 8, 8, 9)

    // 9 9 9 8 9 9 9 8 9
//    gln.solutionFirst(array = array, m = 8000, k = 3)
//    gln.solutionSecond(array = array, m = 8000, k = 3)
    wrapTimerFunction(GreedyLargeNumber::solutionFirst, gln, array, 2147483647, 9)
    wrapTimerFunction(GreedyLargeNumber::solutionSecond, gln, array, 2147483647, 9)
}