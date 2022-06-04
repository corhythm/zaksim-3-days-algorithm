import java.util.StringTokenizer

class Boj5086 {

    fun solve() {
        while (true) {
            val st = StringTokenizer(readln())
            val (numA, numB) = Pair(st.nextToken().toInt(), st.nextToken().toInt())
            if (numA == 0 && numB == 0) break

            if (numB.mod(numA) == 0) {
                println("factor")
            } else if (numA.mod(numB) == 0) {
                println("multiple")
            } else {
                println("neither")
            }
        }
    }
}

fun main() = Boj5086().solve()