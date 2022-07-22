package baekjoon.sliver

class Boj10773 {

    fun solve() {
        val arr = IntArray(100000)
        var top = -1
        var count = 0

        repeat(readln().toInt()) {
            val num = readln().toInt()
            if (num == 0) {
                count -= arr[top--]
            } else {
                arr[++top] = num
                count += arr[top]
            }
        }

        println(count)
    }
}

fun main() = Boj10773().solve()