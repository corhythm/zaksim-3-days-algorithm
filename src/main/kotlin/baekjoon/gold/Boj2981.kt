package baekjoon.gold

import java.util.*

class Boj2981 {

    fun solve() {
        val N = readln().toInt()
        val nums = arrayListOf<Int>()

        repeat(N) {
            val tokenizer = StringTokenizer(readln())
            nums.add(tokenizer.nextToken().toInt())
        }

    }

    private fun gcd(numA: Int, numB: Int): Int { // 피제수(dividend) % 제수(divisor)
        var (dividend, divisor) = if (numA > numB) Pair(numA, numB) else Pair(numB, numA)
        var n: Int

        while (divisor != 0) {
            n = dividend % divisor
            dividend = divisor
            divisor = n
        }

        return dividend
    }
}

fun main() = Boj2981().solve()