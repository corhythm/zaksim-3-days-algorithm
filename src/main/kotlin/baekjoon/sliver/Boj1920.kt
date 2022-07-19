package baekjoon.sliver;

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class Boj1920 {
    fun solve() {
        val N = readln().toInt()
        val A = hashSetOf<Int>()

        var tokenizer = StringTokenizer(readln())
        repeat(N) {
            A.add(tokenizer.nextToken().toInt())
        }

        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val M = readln().toInt()
        tokenizer = StringTokenizer(readln())
        repeat(M) {
            if (A.contains(tokenizer.nextToken().toInt())) {
                bw.write("1\n")
            } else {
                bw.write("0\n")
            }
        }
        bw.close()
    }

    fun solveUsingBinarySearch() {
        val N = readln().toInt()
        val A = IntArray(N)
        var tokenizer = StringTokenizer(readln())
        repeat(N) { A[it] = tokenizer.nextToken().toInt() }
        A.sort()

        val M = readln().toInt()
        tokenizer = StringTokenizer(readln())
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        repeat(M) {
            val findIndex = binarySearch(A, tokenizer.nextToken().toInt())
            if (findIndex >= 0) {
                bw.write("1\n")
            } else {
                bw.write("0\n")
            }
        }
        bw.close()
    }

    private fun binarySearch(arr: IntArray, key: Int): Int {
        var firstIndex = 0 // 탐색 범위의 왼쪽 끝 인덱스
        var lastIndex = arr.size.minus(1) // 탐색 범위의 오른쪽 끝 인덱스

        while (firstIndex <= lastIndex) { // firstIndex가 lastIndex보다 커지기 전까지 반복
            val mid = (firstIndex + lastIndex) / 2 // 중간 위치를 구한다

            if (key < arr[mid]) { // key 값이 중간 위치의 값보다 작을 경우
                lastIndex = mid - 1
            } else if (key > arr[mid]) { // key 값이 중간 위치의 값보다 클 경우
                firstIndex = mid + 1
            } else { // key 값과 중간 위치의 값이 같을 경우
                return mid
            }
        }

        return -1 // 찾고자 하는 값이 존재하지 않을 경우우
    }
}

fun main() {
//    Boj1920().solve()
    Boj1920().solveUsingBinarySearch()
}
