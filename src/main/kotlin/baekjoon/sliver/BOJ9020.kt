package baekjoon.sliver

import java.util.*
import kotlin.math.sqrt


// https://www.acmicpc.net/problem/9020
// 골드바흐의 추측 (Silver 1, Success)

class BOJ9020 {

    // 10001개를 선언하는 이유는 1 ~ 10000 인덱스를 값처럼 사용
    private val primes = BooleanArray(10000.plus(1)) { true }

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
        val numberOfCandidate = nextInt() // 몇 개 출력할 건지

        for (i in 0 until numberOfCandidate) {
            val value = nextInt()
            val (frontPrime, backPrime) = findGoldbachConjecture(value)
            println("$frontPrime $backPrime")
        }
    }

    private fun findGoldbachConjecture(value: Int): Pair<Int, Int> {
        var firstPartition = value / 2
        var secondPartition = value / 2

        while (true) {
            if (primes[firstPartition] && primes[secondPartition]) {
                return Pair(firstPartition, secondPartition)
            }
            firstPartition--
            secondPartition++
        }
    }
}

fun main() = BOJ9020().run()

