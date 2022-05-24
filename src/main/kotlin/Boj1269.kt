import java.util.Scanner

class Boj1269 {

    fun run() = with(Scanner(System.`in`)) {
        val setANum = nextInt()
        val setBNum = nextInt()
        val setA = hashSetOf<Int>()
        val setB = hashSetOf<Int>()

        for (i in 0 until setANum) {
            setA.add(nextInt())
        }
        for (i in 0 until setBNum) {
            setB.add(nextInt())
        }

        val tempSetA = setA.toHashSet()
        val tempSetB = setB.toHashSet()

        setA.removeAll(tempSetB)
        setB.removeAll(tempSetA)

        println(setA.size.plus(setB.size))

    }
}

fun main() = Boj1269().run()