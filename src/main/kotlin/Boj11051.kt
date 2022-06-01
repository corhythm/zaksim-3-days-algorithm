import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.*


// 기준 풀이 => 시간 가장 오래 걸림
//class Boj11051 {
//
//    fun solve() = with(Scanner(System.`in`)) {
//        val binaryCoefficient = combination(nextBigInteger(), nextBigInteger())
//        println(binaryCoefficient.mod(10007.toBigInteger()))
//    }
//
//    private fun combination(n: BigInteger, k: BigInteger) = factorial(n) / (factorial(k) * factorial(n - k))
//
//    private fun factorial(num: Int): Int {
//        if (num == 0 || num == 1) return 1
//        return num.times(factorial(num.minus(1)))
//    }
//
//    private fun factorial(num: Long): Long {
//        if (num == (0.toLong()) || num == (1.toLong())) return 1
//        return num.times(factorial(num.minus(1)))
//    }
//
//    private fun factorial(num: BigInteger): BigInteger { // BigIntger는 무한대
//        if (num == (0.toBigInteger()) || num == (1.toBigInteger())) return 1.toBigInteger()
//        return num.times(factorial(num.minus(1.toBigInteger())))
//    }
//}

// 새로운 input output 사용해서 풀이
//class Boj11051 {
//
//    fun solve() {
//        val st = StringTokenizer(readln())
//        val n = st.nextToken().toBigInteger()
//        val k = st.nextToken().toBigInteger()
//
//        val binaryCoefficient = combination(n, k)
//
//
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//        bw.write("${binaryCoefficient.mod(10007.toBigInteger())}\n")
//        bw.flush()
//        bw.close()
//    }
//
//    private fun combination(n: BigInteger, k: BigInteger) = factorial(n) / (factorial(k) * factorial(n - k))
//
//    private fun factorial(num: BigInteger): BigInteger {
//        if (num == (0.toBigInteger()) || num == (1.toBigInteger())) return 1.toBigInteger()
//        return num.times(factorial(num.minus(1.toBigInteger())))
//    }
//}

// 동적 계획법 풀이
class Boj11051 { // BinaryCoefficient (이항계수)

    private lateinit var dp: Array<IntArray>

    fun solve() {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        dp = Array(n + 1) { IntArray(k + 1) }
        val binaryCoefficient = calculateBinaryCoefficient(n, k)

        val bw = BufferedWriter(OutputStreamWriter(System.out))
        bw.write("${binaryCoefficient.mod(10007)}\n")
        bw.flush()
        bw.close()
    }

    private fun calculateBinaryCoefficient(n: Int, k: Int): Int {
        if (dp[n][k] > 0) { // 이미 풀었던 sub 문제일 경우 값을 재활용
            return dp[n][k]
        }

        if (k == 0 || n == k) { // C(N, 0)이거나 C(N, N)은 무조건 1
            dp[n][k] = 1
            return dp[n][k]
        }

        dp[n][k] =
            (calculateBinaryCoefficient(n - 1, k - 1) + calculateBinaryCoefficient(n - 1, k)) % 10007
        return dp[n][k]
    }
}


fun main() {
    Boj11051().solve()
}
