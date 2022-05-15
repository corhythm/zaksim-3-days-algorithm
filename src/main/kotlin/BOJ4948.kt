import java.util.*
import kotlin.math.sign
import kotlin.math.sqrt

/**
 * Bertrand's postulate
 * #Sieve of Eratosthenes
 * https://www.acmicpc.net/problem/4948
 */
class Boj4948 {

    // 1 ~ 123456
    private val primes = BooleanArray(123456.times(2).plus(1)) { true }

    init {
        // Sieve of Eratosthenes
        primes[0] = false
        primes[1] = false
        // 소수 초기화, 소수 == true, 합성수 == false
        for (i in 2..sqrt(primes.size.toDouble()).toInt()) {
            if (!primes[i]) {
                continue
            }

            for (j in i * i until primes.size step i) {
                primes[j] = false
            }
        }
    }

    fun run() = with(Scanner(System.`in`)) {
        while (true) {
            val value = nextInt()
            if (value == 0) break

            val numberOfPrime = findNumberOfPrime(value)
            println(numberOfPrime)
        }

    }

    // number < ? <= 2 * number 사이의 소수 개수 찾기
    private fun findNumberOfPrime(number: Int): Int {

        var primeCount = 0

        for (i in number + 1..number.times(2)) {
            if (primes[i]) primeCount++
        }
        return primeCount
    }


}

fun main() = Boj4948().run()

