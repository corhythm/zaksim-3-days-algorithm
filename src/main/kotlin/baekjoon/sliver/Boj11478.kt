package baekjoon.sliver

import java.util.*

class Boj11478 {

    fun run() = with(Scanner(System.`in`)) {
        val inputString = next()
        val set = hashSetOf<String>() // 1개짜리는 했으니, 두 개부터 시작하면 됨

        val sb = StringBuilder()
        for (i in inputString.indices) {
            for (j in i until inputString.length) {
                sb.append(inputString.substring(j, j.plus(1)))
                set.add(sb.toString())
            }
            sb.setLength(0)
        }

        println(set.size)
    }

}

fun main() = Boj11478().run()