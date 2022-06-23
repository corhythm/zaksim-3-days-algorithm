package baekjoon.bronze

import java.util.*

class Boj4344 {

    fun run() = with(Scanner(System.`in`)) {

        val num = nextInt()
        for (i in 0 until num) {

            val scores = arrayListOf<Int>()
            val studentNum = nextInt()
            for (j in 0 until studentNum) {
                scores.add(nextInt())
            }

            val average = scores.average()
            var count = 0
            for (j in 0 until studentNum) {
                if (average < scores[j]) {
                    count++
                }
            }

            val percent = String.format("%.3f", count.toDouble().div(studentNum.toDouble()).times(100))
            println("$percent%")
        }
    }
}

fun main() = Boj4344().run()