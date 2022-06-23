package baekjoon.sliver

import java.util.StringTokenizer
import kotlin.math.pow

class Boj1037 {

    fun solve() {
        val divisorNum = readln().toInt() // 약수 개수
        val divisors = arrayListOf<Int>()

        val st = StringTokenizer(readln())
        repeat(divisorNum) {
            divisors.add(st.nextToken().toInt())
        }
        divisors.sort()

        if (divisors.size == 1) {
            println(divisors.first().toDouble().pow(2).toInt())
        } else {
            println(divisors.first().times(divisors.last()))
        }
    }
}

fun main() = Boj1037().solve()