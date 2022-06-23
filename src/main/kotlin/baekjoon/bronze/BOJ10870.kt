package baekjoon.bronze

import java.util.Scanner

// https://www.acmicpc.net/problem/10870
// 피보나치 수 5 (Bronze 2, Success)
class BOJ10870 {

    fun run() = with(Scanner(System.`in`)) {
        val index = nextInt() // 몇 번째 피보나치 수 출력할 건지
        val fibonacciNum = getFibonacciNumber(index)
        println(fibonacciNum)
    }

    private fun getFibonacciNumber(index: Int): Int {
        if (index == 0) return 0
        if (index == 1) return 1

        return getFibonacciNumber(index.minus(1)) + getFibonacciNumber(index.minus(2))
    }

}

fun main() = BOJ10870().run()