package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer


class Boj11660 {

    private val data = arrayListOf<List<Int>>()

    fun solve() {

        var tokenizer = StringTokenizer(readln())
        val (N, M) = Pair(tokenizer.nextToken().toInt(), tokenizer.nextToken().toInt())

        repeat(N) {
            val rowData = readln().split(' ').map { it.toInt() }
            data.add(rowData)
        }

        val bw = BufferedWriter(OutputStreamWriter(System.out))

        repeat(M) {
            tokenizer = StringTokenizer(readln())
            val (x1, y1) = Pair(tokenizer.nextToken().toInt(), tokenizer.nextToken().toInt())
            val (x2, y2) = Pair(tokenizer.nextToken().toInt(), tokenizer.nextToken().toInt())

            val intervalSum = calculateIntervalSum(x1 - 1, y1 - 1, x2 - 1, y2 - 1)
            bw.write("$intervalSum\n")
        }

        bw.flush()
        bw.close()
    }

    private fun calculateIntervalSum(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        var sum = 0

        for (i in y1..y2) {
            for (j in x1..x2) {
                sum += data[i][j]
            }
        }

        return sum
    }
}

fun main() = Boj11660().solve()