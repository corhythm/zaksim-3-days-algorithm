import java.util.StringTokenizer

class Boj8958 {

    fun solve() {
        repeat(StringTokenizer(readln()).nextToken().toInt()) {
            val quizResult = StringTokenizer(readln()).nextToken().toList()

            var result = 0
            var count = 0
            quizResult.forEach {
                if (it == 'O') {
                    result += count.plus(1)
                    count++
                } else {
                    count = 0
                }
            }

            println(result)
        }
    }
}

fun main() = Boj8958().solve()