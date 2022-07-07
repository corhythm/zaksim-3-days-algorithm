package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

//class Boj1010 {
//
//    fun solve() {
//        val testCaseNum = readln().toInt()
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//        repeat(testCaseNum) {
//            val token = StringTokenizer(readln())
//            val (K, N) = Pair(token.nextToken().toInt(), token.nextToken().toInt())
//
//            val result = combination(N.toBigInteger(), K.toBigInteger())
//            bw.write("$result\n")
//            bw.flush()
//        }
//
//        bw.close()
//    }
//
//    private fun combination(n: BigInteger, k: BigInteger) = factorial(n) / (factorial(k) * factorial(n - k))
//
//    private tailrec fun factorial(n: BigInteger, result: BigInteger = 1.toBigInteger()): BigInteger =
//        if (n <= 0.toBigInteger()) result else factorial(n.minus(1.toBigInteger()), result * n)
//}

class Boj1010 {

    val dp = Array(30) { IntArray(30) }

    fun solve() {
        val testCaseNum = readln().toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        for (i in 0 until 30) { // C(n, n), C(n, 0) 은 항상 1
            dp[i][i] = 1
            dp[i][0] = 1
        }

        for (i in 2 until 30) {
            for (j in 1 until 30) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] // e.g. [2][1] = [1][0] + [1][1] -> [2][2] = [1][1] + [2][1]
            }
        }

        repeat(testCaseNum) {
            val token = StringTokenizer(readln())
            val (K, N) = Pair(token.nextToken().toInt(), token.nextToken().toInt())

            bw.write("${dp[N][K]}\n")
            bw.flush()
        }

        bw.close()
    }
}

fun main() = Boj1010().solve()