package baekjoon.bronze

import java.util.Scanner

// https://www.acmicpc.net/problem/10872
// 팩토리얼 (Bronze 3, Success)
class BOJ10872 {

    fun run() = with(Scanner(System.`in`)) {
        val inputNum = nextInt()
        println(factorial(inputNum))
    }

    private fun factorial(num: Int): Int {
        if (num == 1 || num == 0) return 1
        return num.times(factorial(num.minus(1)))
    }
}

fun main() = BOJ10872().run()
