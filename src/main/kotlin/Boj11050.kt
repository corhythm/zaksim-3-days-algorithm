import java.util.Scanner

class Boj11050 {

    fun run() = with(Scanner(System.`in`)) {
        val numA = nextInt()
        val numB = nextInt()

        println(factorial(numA).div(factorial(numB).times(factorial(numA.minus(numB)))))
    }

    private fun factorial(num: Int): Int {
        if (num == 0 || num == 1) return 1
        return num.times(factorial(num.minus(1)))
    }
}

fun main() = Boj11050().run()