package baekjoon.bronze

import java.util.*

// https://www.acmicpc.net/problem/2750
// 수 정렬하기 (Bronze 1, Success)

class BOJ2750 {

    fun run() = with(Scanner(System.`in`)) {

        val numOfInput = nextInt()
        val unsortedNums = IntArray(numOfInput)

        for (i in 0 until numOfInput) {
            val value = nextInt()
            unsortedNums[i] = value
        }

        bubbleSort(unsortedNums)

        unsortedNums.iterator().forEach {
            println(it)
        }
    }

    private fun bubbleSort(unsortedNums: IntArray) {
        for (i in unsortedNums.indices) {
            for (j in  0  until (unsortedNums.size - i - 1)) {
                if (unsortedNums[j + 1] < unsortedNums[j]) {
                    val temp = unsortedNums[j + 1]
                    unsortedNums[j + 1] = unsortedNums[j]
                    unsortedNums[j] = temp
                }
            }
        }
    }

}


fun main() {
    BOJ2750().run()
}