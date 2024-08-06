package org.example.algorithm.greedy

class GreedyCoin {

    /*
    * 거스름돈 문제
    * 500원/100원/50원/10원 -> 무제한
    * 거슬러 줘야 할 돈이 N원일 때동전의 최소개수를 구한다.
    * 단, N은 항상 10의 배수이다.
    *
    */

    /** 거스름돈 N이 주어질 때 최소개수를 반환하는 함수 */
    fun solution(n: Int)
    {
        val coinType = intArrayOf(5000, 1000, 500, 100, 50, 10)
        var count = 0
        var sub = n;

        coinType.forEach {
            count += sub / it
            sub %= it
        }

        println(count)
    }

}

fun main()
{
    val gc = GreedyCoin()
    gc.solution(6600)
}