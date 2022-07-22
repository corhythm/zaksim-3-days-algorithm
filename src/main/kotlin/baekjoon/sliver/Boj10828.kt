package baekjoon.sliver

import java.util.StringTokenizer

class Boj18258 {

    fun solve() {

        val arr = IntArray(10000)
        var top = -1

        repeat(readln().toInt()) {
            val tokenizer = StringTokenizer(readln())
            when (tokenizer.nextToken()) {
                "push" -> {
                    val num = tokenizer.nextToken().toInt()
                    top++
                    arr[top] = num
                }
                "pop" -> {
                    if (top == -1) {
                        println(-1)
                    } else {
                        println(arr[top--])
                    }
                }
                "size" -> println(top.plus(1))
                "empty" -> {
                    if (top == -1) {
                        println(1)
                    } else {
                        println(0)
                    }
                }
                "top" -> {
                    if (top == -1) {
                        println(-1)
                    } else {
                        println(arr[top])
                    }
                }
            }
        }
    }
}

fun main() = Boj18258().solve()