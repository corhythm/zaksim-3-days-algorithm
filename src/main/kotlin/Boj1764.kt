import java.util.Scanner

// https://www.acmicpc.net/problem/1764
// 듣보잡 (Silver 4)
class Boj1764 {

    fun run() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val m = nextInt()
        val doNotSee = hashSetOf<String>()
        val doNotSeeAndListen = hashSetOf<String>()

        for (i in 0 until n) doNotSee.add(next())
        for (i in 0 until m) {
            val doNotListen = next()
            if (doNotSee.contains(doNotListen)) doNotSeeAndListen.add(doNotListen)
        }

        println(doNotSeeAndListen.size)
        doNotSeeAndListen.toList().sorted().forEach { println(it) }
    }
}

fun main() = Boj1764().run()