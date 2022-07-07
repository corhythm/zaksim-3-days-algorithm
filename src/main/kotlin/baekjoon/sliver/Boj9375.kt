package baekjoon.sliver

import java.util.StringTokenizer

class Boj9375 {

    fun solve() {
        val testCase = readln().toInt()
        repeat(testCase) {

            val clothesNum = readln().toInt()
            val clothesMap = hashMapOf<String, Int>()

            repeat(clothesNum) {

                val tokenizer = StringTokenizer(readln())
                tokenizer.nextToken() // clothesName
                val clothesType = tokenizer.nextToken()

                if (clothesMap.containsKey(clothesType)) {
                    clothesMap[clothesType] = clothesMap[clothesType]!!.plus(1)
                } else {
                    clothesMap[clothesType] = 1
                }
            }

            var result = 1
            clothesMap.values.forEach {
                result *= (it + 1)
            }
            println(result - 1)


        }
    }


//    private fun combination(n: Int, k: Int) = factorial(n) / (factorial(k) * factorial(n - k))
//
//    private tailrec fun factorial(n: Int, result: Int = 1): Int =
//        if (n <= 0) result else factorial(n.minus(1), result * n)
}

fun main() = Boj9375().solve()