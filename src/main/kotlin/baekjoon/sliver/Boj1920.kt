package baekjoon.sliver;

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class Boj1920 {
    fun solve() {
        val N = readln().toInt()
        val A = hashSetOf<Int>()

        var tokenizer = StringTokenizer(readln())
        repeat(N) {
            A.add(tokenizer.nextToken().toInt())
        }

        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val M = readln().toInt()
        tokenizer = StringTokenizer(readln())
        repeat(M) {
            if (A.contains(tokenizer.nextToken().toInt())) {
                bw.write("1\n")
            } else {
                bw.write("0\n")
            }
        }
        bw.close()
    }
}

fun main() = Boj1920().solve()
