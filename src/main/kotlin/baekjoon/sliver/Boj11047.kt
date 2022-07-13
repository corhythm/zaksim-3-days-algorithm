package baekjoon.sliver

import java.util.StringTokenizer

class Boj11047 {

    fun solve() {
        val tokenizer = StringTokenizer(readln())
        val coinNum = tokenizer.nextToken().toInt()
        var amount = tokenizer.nextToken().toInt()
        val coins = arrayListOf<Int>()

        repeat(coinNum) {
            coins.add(readln().toInt())
        }

        var i = coins.size.minus(1)
        var count = 0
        while (true) {
            if (amount == 0) break

            if (amount.div(coins[i]) > 0) {
                val num = amount.div(coins[i])
                count += num
                amount -= coins[i].times(num)
                i--
            } else {
                i--
            }
//            println("count=$count, amount=$amount")
        }

        println(count)
    }
}

fun main() = Boj11047().solve()