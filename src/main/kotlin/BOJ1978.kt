import java.util.*
import kotlin.math.sqrt

// https://www.acmicpc.net/problem/1978
// 소수 찾기 (Silver 4, Success)
class BOJ1978 {

    private val primes = BooleanArray(1000.plus(1)) { true }

    // init primes
    init {
        initPrimes()
    }

    private fun initPrimes() {
        primes[0] = false
        primes[1] = false

        for (i in 2..sqrt(primes.size.toDouble()).toInt()) {
            if (!primes[i]) continue

            for (j in i * i until primes.size step i) {
                primes[j] = false
            }
        }
    }

    fun run() = with(Scanner(System.`in`)) {
        val input = nextInt()
        var primeNum = 0

        for (i in 0 until input) {
            val value = nextInt()
            if (primes[value]) {
                primeNum++
            }
        }
        println(primeNum)
    }
}


fun main() = BOJ1978().run()
