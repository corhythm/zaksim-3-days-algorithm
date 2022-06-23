package baekjoon.bronze

import java.util.Scanner

class Boj1934 {

    fun run() = with(Scanner(System.`in`)) {
        val num = nextInt()
        for (i in 0 until num) {
            val numA = nextInt()
            val numB = nextInt()
            println(lcm(numA, numB))
        }
    }

    private fun lcm(a: Int, b: Int): Int {
        var n: Int
        var numA = a
        var numB = b

        while (numB != 0) {
            n = numA % numB
            numA = numB
            numB = n
        }

        return a.times(b).div(numA)
    }
}

fun main() = Boj1934().run()