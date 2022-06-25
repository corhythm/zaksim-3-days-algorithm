package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class Boj2559 {

    fun solve() {
        val tokenizer = StringTokenizer(readln())
        val (n, k) = Pair(tokenizer.nextToken().toInt(), tokenizer.nextToken().toInt())

        val temperatureList = readln().split(' ').map { it.toInt() }
        val maxSum = calculateMaxTemperature(temperatureList, k)

        val bw = BufferedWriter(OutputStreamWriter(System.out))
        bw.write("$maxSum\n")
        bw.flush()
        bw.close()
    }

    private fun calculateMaxTemperature(data: List<Int>, interval: Int): Int {

        var maxSum = Int.MIN_VALUE

        for (i: Int in data.indices) {
            var sum = 0
            if (i.plus(interval) > data.size) break
            data.subList(i, i.plus(interval)).forEach { sum += it }

            if (maxSum < sum) maxSum = sum
//            println("sum: $sum")
        }

        return maxSum
    }

}

fun main() = Boj2559().solve()