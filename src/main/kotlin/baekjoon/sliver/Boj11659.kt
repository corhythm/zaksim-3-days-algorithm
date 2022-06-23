package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

class Boj11659 {

    fun solve() {
        val token = StringTokenizer(readln())
        val (n, m) = Pair(token.nextToken().toInt(), token.nextToken().toInt())

        val data = readln().split(' ').map { it.toInt() }
        val prefixSum = data.toList().toMutableList()

        data.forEachIndexed { index, _ ->
            if (index == 0) {
                prefixSum[index] = data[index]
            } else {
                prefixSum[index] = prefixSum[index.minus(1)] + data[index]
            }
        }

        val bw = BufferedWriter(OutputStreamWriter(System.out))

        repeat(m) {
            val tempToken2 = StringTokenizer(readln())
            val (start, end) = Pair(tempToken2.nextToken().toInt(), tempToken2.nextToken().toInt())

            // 그냥 for문으로 더하면 시간 초과가 나기 때문에 prefix sum 방식으로 구해야 함
//            val sum = data.subList(start.minus(1), end).sum()

            if (start.minus(1) == 0) {
                bw.write("${prefixSum[end.minus(1)]}\n") // println으로 출력하면 시간 초과 난다
            } else {
                bw.write("${prefixSum[end.minus(1)] - prefixSum[start.minus(2)]}\n")
            }

            bw.flush()
        }

        bw.close()

    }
}

fun main() = Boj11659().solve()