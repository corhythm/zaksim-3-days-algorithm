import java.util.Scanner
import kotlin.math.sqrt

// https://www.acmicpc.net/problem/11653
// 소인수분해
class BOJ11653 {

    private val primes = BooleanArray(10000000.plus(1)) { true }

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
        var compositeNum = nextInt()
        if (compositeNum == 1) return

        var i = 2
        while (i < primes.size) {
            if (compositeNum == 1) break

            if (primes[i]) {
                if (compositeNum.mod(i) == 0) {
                    println(i)
                    compositeNum /= i
                    continue
                }
                i++
                continue
            }
            i++
        }

    }
}

fun main() = BOJ11653().run()