import java.util.*
import kotlin.math.roundToInt

// https://www.acmicpc.net/problem/2108
// 통계학(Silver 3)

/**
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 */

class Boj2108 {

    fun run() = with(Scanner(System.`in`)) {
        val numList = arrayListOf<Int>()
        for (i in 0 until nextInt()) {
            numList.add(nextInt())
        }

        numList.sort()

        val arithmeticMean = numList.sum().toDouble().div(numList.size).roundToInt() // 산술평균
        val median = numList[numList.size.div(2)] // 중앙값
        val mode = getMode(numList) // 최빈값
        val range = numList.last() - numList.first() // 범위

        println(arithmeticMean)
        println(median)
        println(mode)
        println(range)
    }

    private fun getMode(list: MutableList<Int>): Int {
        val modeCount = list.groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { (_, value) -> value }
            .toMap()

        val keys = modeCount.keys.toList()
        val values = modeCount.values.toList()

        if (keys.size == 1)
            return keys.first()

        return if (values[0] == values[1])
            keys[1]
        else
            keys.first()
    }
}

fun main(): Unit = Boj2108().run()


