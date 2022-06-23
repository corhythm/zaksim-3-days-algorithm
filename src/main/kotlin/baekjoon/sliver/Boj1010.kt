package baekjoon.sliver

import java.util.*

class Boj1010 {

    fun solve() {
        val testCase = readln().toInt()
        repeat(testCase) {
            val token = StringTokenizer(readln())
            val (west, east) = Pair(token.nextToken().toInt(), token.nextToken().toInt())
            println("$west $east")
        }

    }
}

fun main() = Boj1010().solve()