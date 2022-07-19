package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Scanner
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/10816
// 숫자 카드 (Silver 4)

class Boj10816 {

    fun solve() = with(Scanner(System.`in`)) {
        val num = nextInt()
        val numbersMap = hashMapOf<Int, Int>()
        for (i in 0 until num) {
            val value = nextInt()
            numbersMap[value] = if (numbersMap.containsKey(value)) numbersMap[value]!!.plus(1) else 1
        }

        val myNum = nextInt()
        val stringBuild = StringBuilder()
        for (i in 0 until myNum) {
            stringBuild.append(numbersMap.getOrDefault(nextInt(), 0)).append(" ")
        }

        println(stringBuild)
    }

    fun solveUsingBinarySearch() {
        val num = readln().toInt()
        var tokenizer = StringTokenizer(readln())
        val arr = IntArray(num)
        repeat(num) { arr[it] = tokenizer.nextToken().toInt() }
        arr.sort()

        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val num2 = readln().toInt()
        tokenizer = StringTokenizer(readln())
        val sb = StringBuilder()
        repeat(num2) {
            val findNum = tokenizer.nextToken().toInt()
            sb.append(upperBound(arr, findNum) - lowerBound(arr, findNum)).append(" ")
        }

        bw.write("$sb\n")
        bw.close()
    }

    private fun lowerBound(arr: IntArray, key: Int): Int {
        var firstIndex = 0
        var lastIndex = arr.size

        // firstIndex와 lastIndex가 같아질 때까지 반복
        while (firstIndex < lastIndex) {
            val mid = (firstIndex + lastIndex) / 2 // 중간 위치를 구하고

            // key 값이 중간 위치의 값보다 작을 경우 (중복 원소에 대해 왼쪽으로 탐색하도록 상한을 내린다)
            if (key <= arr[mid]) {
                lastIndex = mid
            } else {
                firstIndex = mid + 1
            }
        }

        return firstIndex
    }

    private fun upperBound(arr: IntArray, key: Int): Int {
        var firstIndex = 0
        var lastIndex = arr.size

        // firstIndex랑 lastIndex가 같아질 때까지 반복
        while (firstIndex < lastIndex) {
//            val mid = firstIndex + ((lastIndex - firstIndex) / 2) // StackOverflow가 발생할 수 있으니 이렇게 사용하는 걸 권장
            val mid = (firstIndex + lastIndex) / 2

            if (key < arr[mid]) { // key값이 중간 위치의 값보다 작을 경우
                lastIndex = mid
            } else { // 중복 원소의 경우 else에서 처리
                firstIndex = mid + 1
            }
        }

        return firstIndex
    }

//    private fun binarySearch(arr: IntArray, key: Int): Int {
//        var firstIndex = 0 // 탐색 범위의 왼쪽 끝 인덱스
//        var lastIndex = arr.size.minus(1) // 탐색 범위의 오른쪽 끝 인덱스
//
//        while (firstIndex <= lastIndex) { // firstIndex가 lastIndex보다 커지기 전까지 반복
//            val mid = (firstIndex + lastIndex) / 2 // 중간 위치를 구한다
//
//            if (key < arr[mid]) { // key 값이 중간 위치의 값보다 작을 경우
//                lastIndex = mid - 1
//            } else if (key > arr[mid]) { // key 값이 중간 위치의 값보다 클 경우
//                firstIndex = mid + 1
//            } else { // key 값과 중간 위치의 값이 같을 경우
//                return mid
//            }
//        }
//
//        return -1 // 찾고자 하는 값이 존재하지 않을 경우우
//    }

}

fun main() {
//    Boj10816().solve()
    Boj10816().solveUsingBinarySearch()
}

