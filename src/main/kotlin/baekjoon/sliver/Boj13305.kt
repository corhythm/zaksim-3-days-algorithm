package baekjoon.sliver

import java.math.BigInteger
import java.util.StringTokenizer
import kotlin.math.cos

class Boj13305 {

    fun solve() {
        val k = readln().toInt()
        val dist = arrayListOf<Int>()
        val cost = arrayListOf<Int>()

        var tokenizer = StringTokenizer(readln())
        repeat(k.minus(1)) { dist.add(tokenizer.nextToken().toInt()) }

        tokenizer = StringTokenizer(readln())
        repeat(k) { cost.add(tokenizer.nextToken().toInt()) }

        var res: BigInteger = 0.toBigInteger()
        var minCost = cost[0]
        for (i in 0 until k.minus(1)) {
            if (minCost > cost[i]) {
                minCost = cost[i]
            }
            res += (minCost.toBigInteger() * dist[i].toBigInteger())
        }

        println(res)

    }
}

fun main() = Boj13305().solve()