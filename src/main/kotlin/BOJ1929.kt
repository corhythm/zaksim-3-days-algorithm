import java.util.Scanner
import kotlin.math.sqrt

class BOJ1929 {

    private val primes = BooleanArray(1000000.plus(1)) { true }

    init {
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

        for (i in min..max) {
            if (primes[i]) {
                println(i)
            }
        }
    }
}

fun main() = BOJ1929().run()