import java.util.Scanner

// https://www.acmicpc.net/problem/10816
// 숫자 카드 (Silver 4)

class Boj10816 {

    fun run() = with(Scanner(System.`in`)) {
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
}

fun main() = Boj10816().run()

