package baekjoon.sliver

import java.util.*


class Boj1874 {

    fun solve() {
        val sb = StringBuilder() // 출력할 결과물 저장
        val stack = Stack<Int>()
        var N = readln().toInt()
        var start = 0

        // N 번 반복
        while (N-- > 0) {
            val value = readln().toInt()
            if (value > start) {

                // start + 1부터 입력받은 value 까지 push 한다.
                for (i in start + 1..value) {
                    stack.push(i)
                    sb.append("+").append("\n") // + 를 저장한다.
                }
                start = value // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            } else if (stack.peek() != value) {
                println("NO")
                return
            }
            stack.pop()
            sb.append("-").append("\n")
        }

        println(sb)
    }
}

fun main() = Boj1874().solve()