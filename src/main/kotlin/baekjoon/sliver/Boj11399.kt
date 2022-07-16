package baekjoon.sliver

import java.util.StringTokenizer

class Boj11399 {

    fun solve() {
        val personNum = readln().toInt()
        val tokenizer = StringTokenizer(readln())
        val times = arrayListOf<Int>()

        repeat(personNum) {
            times.add(tokenizer.nextToken().toInt())
        }
        times.sort()

        var totalTimes = 0
        var pastTimes = 0

        times.forEach {
            pastTimes += it
            totalTimes += pastTimes
        }

        println(totalTimes)
    }
}

fun main() = Boj11399().solve()