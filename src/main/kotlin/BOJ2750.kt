import java.util.*

/**
 * https://www.acmicpc.net/problem/2750
 */

class BOJ2750 {

    fun run() = with(Scanner(System.`in`)) {

        val numOfInput = nextInt()
        val unsortedNums = IntArray(numOfInput)
        for (i in 0 until numOfInput) {
            val value = nextInt()
            unsortedNums[i] = value
        }

        for (i in unsortedNums.indices) {
            for (j in  0  until (unsortedNums.size - i - 1)) {
                if (unsortedNums[j + 1] < unsortedNums[j]) {
//                    println("${unsortedNums[j + 1]} < ${unsortedNums[j]}")
                    val temp = unsortedNums[j + 1]
                    unsortedNums[j + 1] = unsortedNums[j]
                    unsortedNums[j] = temp
                }
//                println("$i, ${unsortedNums.toList()}")
            }
        }

//        println("sorted Array")
        unsortedNums.iterator().forEach {
            println(it)
        }
    }

}


fun main() {
    BOJ2750().run()
}