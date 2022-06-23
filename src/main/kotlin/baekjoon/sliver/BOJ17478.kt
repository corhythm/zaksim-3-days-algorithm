package baekjoon.sliver

import java.util.Scanner


// https://www.acmicpc.net/problem/17478
// 재귀함수가 뭔가요? (Silver 5, Success)

class BOJ17478 {

    private var dashCount = 0

    fun run() = with(Scanner(System.`in`)) {
        val recursiveCount = nextInt()
        println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
        chatBoatSaid(recursiveCount)
    }

    private fun chatBoatSaid(recursiveCount: Int) {
        val dashCount = this.dashCount
        printDash(dashCount)
        println("\"재귀함수가 뭔가요?\"")

        if (recursiveCount == 0) {
            printDash(dashCount)
            println("\"재귀함수는 자기 자신을 호출하는 함수라네\"")
        } else {
            printDash(dashCount)
            println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.")
            printDash(dashCount)
            println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.")
            printDash(dashCount)
            println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"")
            this.dashCount = dashCount.plus(1)
            chatBoatSaid(recursiveCount.minus(1))
        }
        printDash(dashCount)
        println("라고 답변하였지.")
    }

    private fun printDash(times: Int) {
        for (i in 0 until times) {
            print("____")
        }
    }
}

fun main() = BOJ17478().run()