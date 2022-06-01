import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Boj1676 {

//    fun solve() {
//        val br = BufferedReader(InputStreamReader(System.`in`))
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//        repeat(br.readLine().toInt()) {
//            val token = StringTokenizer(br.readLine())
//            val sum = (token.nextToken().toInt() + token.nextToken().toInt()).toString()
//            bw.write(sum + "\n")
//        }
//        bw.flush()
//        bw.close()
//    }

    fun solve() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var num = br.readLine().toInt()
        var count = 0

        while (num >= 5) {
            count += num.div(5)
            num /= 5
        }

        bw.write("${count.toString()}\n")

        br.close()
        bw.flush()
        bw.close()
    }

    // 이 문제는 factorial 사용하면 성공 못함
    private fun recursiveFactorial(n: Int): Int {
        if (n <= 0) return 1
        return n.times(recursiveFactorial(n.minus(1)))
    }

    private tailrec fun factorial(n: Int, result: Int = 1): Int =
        if (n <= 0) result else factorial(n.minus(1), result * n)

}

fun main() {
    Boj1676().solve()
}