package baekjoon.gold

import java.util.*

class Boj2981 {

    fun run() = with(Scanner(System.`in`)) {
        val num = nextInt()
        val list = arrayListOf<Int>()
        val availableDivisors = arrayListOf<Int>()

        for (i in 0 until num) {
            list.add(nextInt())
        }

        var commonDivisor = -1

        run findDivisor@ {
            for (i in 0 until list.size.minus(1)) {
                val gcd = gcd(list[i], list[i.plus(1)])
                for (j in list.indices) {
                    if (list[j] % gcd != 0) break
                    if (j == list.size.minus(1)) {
                        commonDivisor = gcd
                        return@findDivisor
                    }
                }
            }
        }

        print("$commonDivisor ")
        var i = 0
        commonDivisor *= 2
        while (true) {
            if (list[i] % commonDivisor != 0) break

            if (i == list.size.minus(1)) {
                println(" $commonDivisor")
                commonDivisor *= 2
                i = 0
            }
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

fun main() = Boj2981().run()