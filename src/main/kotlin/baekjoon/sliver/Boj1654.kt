package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class Boj1654 {

    fun solve() {
        val tokenizer = StringTokenizer(readln())
        val K = tokenizer.nextToken().toInt()
        val N = tokenizer.nextToken().toInt()
        val arr = IntArray(K)

        var min: Long = 0
        var max: Long = 0
        var mid: Long = 0

        repeat(K) {
            arr[it] = readln().toInt()
            if (arr[it] > max) {
                max = arr[it].toLong()
            }
        }

        max++ // max가 1보다 작으면 크면 mid가 0이므로 0으로 나눗셈을 해야한다

        while (min < max) {
            mid = (max + min) / 2 // 범위 내에서 중간 길이 찾기

            var count: Long = 0

            // 구한 중간 길이로 잘라서 총 몇 개가 만들어지는지 구한다
            for (i in arr.indices) {
                count += (arr[i] / mid)
            }

            // [UpperBound 방식]
            if (count < N) { // mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면 자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
                max = mid
            } else { // 자르고자 하는 길이를 늘리기 위해 최소 길이를 늘린다.
                min = mid + 1
            }
        }

        val bw = BufferedWriter(OutputStreamWriter(System.out))
        bw.write("${min.minus(1)}\n")
        bw.flush()
        bw.close()
    }

}

fun main() = Boj1654().solve()
