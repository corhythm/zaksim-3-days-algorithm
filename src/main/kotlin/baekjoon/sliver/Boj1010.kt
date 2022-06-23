package baekjoon.sliver

import java.util.*

class Boj1010 {

    fun solve() {
        val testCaseNum = readln().toInt()
        repeat(testCaseNum) {
            val token = StringTokenizer(readln())
            val (west, east) = Pair(token.nextToken().toInt(), token.nextToken().toInt())
        }

    }
}

fun main() = Boj1010().solve()