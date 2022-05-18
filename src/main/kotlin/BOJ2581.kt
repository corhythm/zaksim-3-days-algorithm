import java.util.Scanner
import kotlin.math.sqrt

// https://www.acmicpc.net/problem/2581
// 소수 (Silver 5, Success)
class BOJ2581 {

    private val primes = BooleanArray(10000.plus(1)) { true }

    init {
        // 소수 초기화
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

        val min = nextInt()
        val max = nextInt()
        val primesInRange = arrayListOf<Int>()

        for (i in min..max) {
            if (primes[i]) {
                primesInRange.add(i)
            }
        }

        if (primesInRange.isEmpty()) {
            println(-1)
            return
        }

        println(primesInRange.sum())
        println(primesInRange.first())
    }

}

fun main() {
    BOJ2581().run()
}
