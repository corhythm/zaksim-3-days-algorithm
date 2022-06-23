package baekjoon.bronze

import java.util.*

// https://www.acmicpc.net/problem/2798
// 블랙잭 (Bronze 2, Success)

class BOJ2798 {

    fun run() = with(Scanner(System.`in`)) {
        val cardNum = nextInt()
        val dealerNum = nextInt()

        val cards = IntArray(cardNum)
        cards.forEachIndexed { index, _ -> cards[index] = nextInt() }


        findCloseNumber(cards, dealerNum)
    }

    private fun findCloseNumber(cards: IntArray, dealerNum: Int) {
        var closeNum = 0

        for (i in cards.indices) {
            for (j in i.plus(1) until cards.size) {
                for (k in j.plus(1) until cards.size) {
                    val sum = cards[i].plus(cards[j]).plus(cards[k])
                    if (sum in (closeNum.plus(1)) .. dealerNum) {
                        closeNum = sum
                    }
                }
            }
        }

        println(closeNum)

    }
}

fun main() = BOJ2798().run()