import java.util.Scanner

class Boj14425 {
    fun run() = with(Scanner(System.`in`)) {
        val inputNum = nextInt()
        val checkNum = nextInt()
        val stringSet = hashSetOf<String>()

        for (i in 0 until inputNum) {
            stringSet.add(next())
        }

        var count = 0
        for (i in 0 until checkNum) {
            val checkValue = next()
            if (stringSet.contains(checkValue)) {
                count++
            }
        }
        println(count)
    }
}

fun main() = Boj14425().run()