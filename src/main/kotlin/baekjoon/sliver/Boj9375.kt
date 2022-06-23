package baekjoon.sliver

import java.util.StringTokenizer

class Boj9375 {

    fun solve() {
        val testCase = StringTokenizer(readln()).nextToken().toInt()
        repeat(testCase) {

            val clothesNum = StringTokenizer(readln()).nextToken().toInt()
            val set = hashSetOf<String>()
            repeat(clothesNum) {
                val st = StringTokenizer(readln())
                val clothesName = st.nextToken()
                val clothesType = st.nextToken()

                set.add(clothesType)
            }

            val caseNum = combination(clothesNum, set.size)
            println(caseNum)
        }

    }

    private fun combination(n: Int, until: Int): Int {
        var count = 0
        for (i in 1..until) {
            var result = factorial(n).div(factorial(i).times(factorial(n.minus(i))))
            if (i != 1 && n != until) {
                result /= 2
            }
            println("$i: $result")
            count += result
        }
        return count
    }

    private tailrec fun factorial(n: Int, result: Int = 1): Int =
        if (n <= 0) result else factorial(n.minus(1), result * n)
}

fun main() = Boj9375().solve()